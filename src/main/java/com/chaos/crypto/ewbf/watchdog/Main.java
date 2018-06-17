package com.chaos.crypto.ewbf.watchdog;

import com.chaos.crypto.ewbf.watchdog.config.AppConfiguration;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.chaos.crypto.ewbf.watchdog")
public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		LOGGER.info("Originally designed for EWBF 0.3.4b");

		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Main.class)
				.web(false)
				.logStartupInfo(true)
				.build()
				.run(args);
		applicationContext.getBean(MinerController.class).startMining();
	}
}
