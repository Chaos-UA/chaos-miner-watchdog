package com.chaos.crypto.ewbf.watchdog.checker;

import com.chaos.crypto.ewbf.watchdog.nvidia.sli.dtd.Gpu;
import com.chaos.crypto.ewbf.watchdog.nvidia.sli.dtd.NvidiaSmiLog;
import com.chaos.crypto.ewbf.watchdog.nvidia.sli.dtd.Utilization;
import lombok.SneakyThrows;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.ShutdownHookProcessDestroyer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class NvidiaSmiChecker implements MinerChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(NvidiaSmiChecker.class);
    private static final Pattern GPU_UTILIZATION_PERCENTAGE = Pattern.compile("(\\d+) %");
    private long startedAt;

    private static final JAXBContext JAXB_CONTEXT;

    static {
        try {
            JAXB_CONTEXT = JAXBContext.newInstance(NvidiaSmiLog.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private final File executableFile;
    private final int minGpuUtilization;

    @Autowired
    public NvidiaSmiChecker(@Value("${healthChecker.nvidiaSmi.executableFile}") File executableFile, @Value("${healthChecker.nvidiaSmi.minGpuUtilization}") int minGpuUtilization) {
        this.executableFile = executableFile;
        this.minGpuUtilization = minGpuUtilization;
        getSnapshot();
    }

    @Override
    public String getName() {
        return "nvidia-sli checker";
    }

    @Override
    public String detectIssue() {
        NvidiaSmiLog nvidiaSmiLog = getSnapshot();

        return checkGpusLoad(nvidiaSmiLog);
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void resetState() {
        startedAt = System.currentTimeMillis();
    }

    private String checkGpusLoad(NvidiaSmiLog nvidiaSmiLog) {
        if (System.currentTimeMillis() - startedAt < 60_000) {
            return null;
        }
        LOGGER.info("Checking GPUs utilization");
        List<String> errors = new ArrayList<>();
        for (Gpu gpu : nvidiaSmiLog.getGpu()) {
            Utilization utilization = gpu.getUtilization();
            Matcher matcher = GPU_UTILIZATION_PERCENTAGE.matcher(utilization.getGpuUtil());
            matcher.find();
            int gpuUtilization = Integer.valueOf(matcher.group(1));
            if (gpuUtilization < minGpuUtilization) {
                errors.add(String.format("GPU%s utilization is %s, but min required is: %s", gpu.getId(), gpuUtilization, minGpuUtilization));
            }
        }

        return errors.isEmpty() ? null : errors.toString();
    }

    @SneakyThrows
    private NvidiaSmiLog getSnapshot() {
       // DefaultExecutor executor = new DefaultExecutor();
        String cmd = executableFile.getAbsolutePath() + " -x -q";
        Process process = Runtime.getRuntime().exec(cmd);

        String output = IOUtils.toString(process.getInputStream(), "UTF-8");
        output = output.replaceAll("SYSTEM \"nvsmi_device_v9.dtd\"", "");

        if (process.isAlive()) {
            process.destroy();
            throw new RuntimeException("SMI Process should be dead");
        }

        NvidiaSmiLog result = (NvidiaSmiLog) JAXB_CONTEXT.createUnmarshaller().unmarshal(new ByteArrayInputStream(output.getBytes()));
        return result;
    }
}
