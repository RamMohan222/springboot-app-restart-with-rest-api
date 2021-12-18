package com.example.apprestartwithrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	private static Logger LOG = LoggerFactory.getLogger(AppController.class);

	@GetMapping("/status")
	public String getMessage() {
		return Thread.currentThread().getName() + "::Application is running...!";
	}

	@GetMapping("/restart")
	public String restart() {
		LOG.info("App about to restart");
		AppRestartWithRestApiApplication.restart();
		LOG.info("App restart done!!");
		return "App restarted...";
	}
}
