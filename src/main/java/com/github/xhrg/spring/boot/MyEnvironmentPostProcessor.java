package com.github.xhrg.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import com.github.xhrg.spring.helper.Utils;

//这个扩展是springboot的扩展，他不需要注解，需要/META-INF/spring.factories配置
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    // environment的environment.getPropertySources().addFirst(null);提供了向spring上下文提供xx的能力
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Utils.printStack();

        // environment.getPropertySources().addFirst(null);
    }

}
