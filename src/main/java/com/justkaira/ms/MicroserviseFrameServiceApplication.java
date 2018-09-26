package com.justkaira.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.justkaira.spring.MsApplicationRunner;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class MicroserviseFrameServiceApplication extends MsApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviseFrameServiceApplication.class, args);
	}
}
