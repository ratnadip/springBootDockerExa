package com.example.springBootDockerExa;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/docker")
public class IndexController {
	private static final Logger LOG = LogManager.getLogger(IndexController.class.getName());

	/*
	 * @Autowired RestTemplate restTemplete;
	 * 
	 * @Bean RestTemplate restTemplate() { return new RestTemplate(); }
	 */
@GetMapping(value = "/index")
public String index() {
	return "Spring boot docker example";
}
@GetMapping(value = "/elk")
public String helloWorld() {
	String response = "Welcome to JavaInUse" + new Date();
	LOG.log(Level.INFO, response);

	return response;
}

@GetMapping(value = "/exception")
public String exception() {
	String response = "";
	try {
		throw new Exception("Exception has occured....");
	} catch (Exception e) {
		e.printStackTrace();
		LOG.error(e);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String stackTrace = sw.toString();
		LOG.error("Exception - " + stackTrace);
		response = stackTrace;
	}

	return response;
}

}
