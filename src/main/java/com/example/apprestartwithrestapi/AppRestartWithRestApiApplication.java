package com.example.apprestartwithrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppRestartWithRestApiApplication {

	private static Logger LOG = LoggerFactory.getLogger(AppRestartWithRestApiApplication.class);
	private static ConfigurableApplicationContext context = null;

	public static void main(String[] args) {
		context = SpringApplication.run(AppRestartWithRestApiApplication.class, args);
	}

	public static void restart() {
		// Do some cleanup activities!! if any thing is required.
		LOG.info("SpringBoot App Started...");
		ApplicationArguments args = context.getBean(ApplicationArguments.class);
		Thread thread = new Thread(() -> {
			LOG.info("app context about to close");
			context.close();
			context = SpringApplication.run(AppRestartWithRestApiApplication.class, args.getSourceArgs());
		});
		thread.setDaemon(false);
		thread.start();
		LOG.info("SpringBoot App Restart Done!");
	}

}
