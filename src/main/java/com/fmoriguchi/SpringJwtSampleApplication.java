package com.fmoriguchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author fmoriguchi
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringJwtSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtSampleApplication.class, args);
	}
}
