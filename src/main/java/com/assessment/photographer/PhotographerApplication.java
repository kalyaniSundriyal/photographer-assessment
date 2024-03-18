package com.assessment.photographer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PhotographerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotographerApplication.class, args);
		log.info("server.started");
	}

}
