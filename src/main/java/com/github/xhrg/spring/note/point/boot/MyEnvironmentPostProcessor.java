package com.github.xhrg.spring.note.point.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import com.github.xhrg.spring.note.helper.LineUtils;

//这个扩展是springboot的扩展，他不需要注解，需要/META-INF/spring.factories配置
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

	// environment的environment.getPropertySources().addFirst(null);提供了向spring上下文提供xx的能力
	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		LineUtils.toTree(false);
		// environment.getPropertySources().addFirst(null);
		String v = environment.getProperty("key1");
		System.out.println(v);
	}

}
