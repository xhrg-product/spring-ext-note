package com.github.xhrg.spring.note.point.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.note.helper.LineUtils;

//通常用来获取配置
@Component
public class MyEnvironmentAware implements EnvironmentAware {

//	@Value("${key1}")
	private String value;

	// 这里的Environment参数可以帮助我们获取spring系统的参数
	@Override
	public void setEnvironment(Environment environment) {
		LineUtils.toTree(false);
		String value1 = environment.getProperty("key1");
		System.out.println(value1);
	}
	
	@Value("${key1}")
	public void setValue(String value) {
		this.value = value;
	}
}
