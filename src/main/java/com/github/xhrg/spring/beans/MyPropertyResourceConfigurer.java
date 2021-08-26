package com.github.xhrg.spring.beans;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.helper.Utils;

@Component
public class MyPropertyResourceConfigurer extends PropertyResourceConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
            throws BeansException {
        Utils.printStack();
//        Utils.addLine();
    }

}
