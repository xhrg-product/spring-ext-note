package com.github.xhrg.spring.note.point.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.note.helper.LineUtils;

@Component
public class MyInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        LineUtils.toTree(false);
    }
}
