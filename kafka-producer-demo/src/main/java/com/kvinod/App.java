package com.kvinod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
@SpringBootApplication
public class App {
	
	@Autowired
	KafkaTemplate<String, String> template;

	Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping
	public String getMessage(@RequestParam String message) {
		logger.info("Got this message: " + message);
		template.send("test", "Message from producer is: " + message);
		return "Did you type: " + message + "?";
	}
}



