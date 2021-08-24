package com.github.xhrg.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.xhrg.spring.helper.Utils;

@SpringBootApplication
public class SpringExtShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExtShowApplication.class, args);
		Utils.printCC();
	}

}
