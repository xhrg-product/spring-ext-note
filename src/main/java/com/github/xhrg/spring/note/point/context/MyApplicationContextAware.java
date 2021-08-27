package com.github.xhrg.spring.note.point.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.note.helper.LineUtils;

@Component
public class MyApplicationContextAware implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LineUtils.toTree(false);
    }
}
