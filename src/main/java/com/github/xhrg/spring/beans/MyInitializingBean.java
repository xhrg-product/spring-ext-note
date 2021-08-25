package com.github.xhrg.spring.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.helper.Utils;

@Component
public class MyInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        Utils.printStack();
        Utils.addLine();
    }

}
