package com.chaos.crypto.ewbf.watchdog.chaosewbfwatchdog;

import com.chaos.crypto.ewbf.watchdog.checker.NvidiaSmiChecker;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.net.InetAddress;

public class MainTests {

	@Test
	public void contextLoads() throws Exception {

		InetAddress inetAddress = InetAddress.getByAddress(new byte[] {8, 8, 8, 8});

		System.out.println(inetAddress.isReachable(5000));
	}

	@Test
	public void test2() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = restTemplate.getForEntity("https://www.whatismyip.com", String.class);
		Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
		System.out.println(result.getBody());
	}

	@Test
	public void testNvidiaSmi() throws Exception {
		NvidiaSmiChecker checker = new NvidiaSmiChecker(new File("C:\\\\Program Files\\\\NVIDIA Corporation\\\\NVSMI\\\\nvidia-smi.exe"), 70);
		checker.resetState();
		checker.detectIssue();
	}

}
