package com.github.xhrg.spring.note.point.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.note.helper.LineUtils;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LineUtils.toTree(false);
        if (beanName.toLowerCase().contains("myfactory") || beanName.toLowerCase().contains("person")) {
            System.out.println(1);
        }
        if(bean.getClass().getName().toString().contains("person")) {
            System.out.println(1);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LineUtils.toTree(false);
        return bean;
    }

}
