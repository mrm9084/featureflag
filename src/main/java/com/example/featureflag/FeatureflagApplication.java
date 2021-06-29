package com.example.featureflag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class FeatureflagApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureflagApplication.class, args);
	}

}
