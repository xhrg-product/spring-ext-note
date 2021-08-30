package com.github.xhrg.spring.note.point.beans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.github.xhrg.spring.note.md.Person;

/**
 * 通常我们会使用spring的autowired注入一个属性到一个类中。
 * 假设我们要注入的这个属性比较负责，需要手动去new，然后注入，这个时候，就需要使用到FactoryBean了。
 * 读者可以看看开源实现，基本上FactoryBean都是和InitializingBean一起出现的。
 * 
 * ehcache,dubbo,mybatis都使到了FactoryBean 我觉得FactoryBean和@bean的效果差不多
 */
@Component
public class MyFactoryBean implements FactoryBean<Person>, InitializingBean {

    private Person person;

    private int age;

    private String name;

    @Override
    public Person getObject() throws Exception {
        return this.person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        this.person = person;
    }
}
