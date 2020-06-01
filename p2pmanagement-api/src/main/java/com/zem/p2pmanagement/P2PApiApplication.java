package com.zem.p2pmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = {P2PApiApplication.class, Jsr310Converters.class})
public class P2PApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2PApiApplication.class, args);
	}

}
