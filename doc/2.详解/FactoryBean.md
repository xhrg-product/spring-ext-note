## FactoryBean详解

在spring中，如果我们要给类注入一个属性对象，怎么做，通常可以使用autowired注解即可。

但是有这么一个场景，我们需要注入的对象的初始化有一些复杂，希望通过代码new Person();然后设置一些属性，然后注入那么autowired就不行了，
这个时候FactoryBean就登场了。该接口提供了一个getObject方法。

## 参考mybatis

参考MybatisAutoConfiguration中的sqlSessionFactory方法。他最早 new SqlSessionFactoryBean()，最后手动调用getObject()方法获取sqlSessionFactory。
我们可以看到getObject是这个类代码里面手动调用的，那与其手动调用，和把getObject里面的逻辑直接复制过来岂不是一样的。
根据这里的代码，我可以大致判断以下2点
* @Bean注解的功能和FactoryBean几乎一样，mybatis的MybatisAutoConfiguration用的其实就是@Bean
* mybatis之所以使用了sqlSessionFactoryBean然后getObject，而不是把getObject托管给spring去调用，目的是为了该类的作用兼容。
也就是说，如果mybatis没有用到MybatisAutoConfiguration，那么sqlSessionFactoryBean的getObject就是spring框架来调用的扩展点。


还记得我们之前配置mybatis-spring的时候有这么一段代码
```java
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
   <property name="dataSource" ref="dataSource"/>
   <property name="typeAliasesPackage" value="com.xxx"/>
</bean>
```
我现在给一个类通过xml注入sqlSessionFactory，那么得到的应该是sqlSessionFactory，还是SqlSessionFactoryBean呢？？
答: 其实是sqlSessionFactory


## PersonFactoryBean和Person的注入关系

请看如下代码
```java
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
```

这种场景，spring会注入几个Bean?
答：2个。Person是一个bean，对应的name是myFactoryBean。而MyFactoryBean对应的beanName是&myFactoryBean

如果我们把@Component改为@Component("person"),则注入的Person这个bean的name是person，而MyFactoryBean对应的bean的name则是&person

以上通过.getBeanNamesForType(MyFactoryBean.class);可以测试得到。spring的注入是按照类型注入的，所以person是完全可以注入进去的。