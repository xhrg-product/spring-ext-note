package com.github.xhrg.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.helper.Utils;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Utils.printStack();
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Utils.printStack();
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Utils.printStack();
    }

}
