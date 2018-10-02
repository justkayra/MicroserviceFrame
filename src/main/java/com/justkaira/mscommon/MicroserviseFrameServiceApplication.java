package com.justkaira.mscommon;

import com.justkaira.mscommon.service.DefaultService;
import com.justkaira.mscommon.service.ErrorService;
import com.justkaira.spring.MsApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackageClasses = {DefaultService.class, ErrorService.class})
public class MicroserviseFrameServiceApplication extends MsApplicationRunner {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviseFrameServiceApplication.class, args);
	}
}
