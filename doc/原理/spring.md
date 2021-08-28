## spring核心

spring启动的时候，会把bean实例化，并且对bean的属性注入他所依赖的对象，如下所示

```java
@Component
public class Person{
 @autowired
 private Company company;
}

@Component
public class Company{
}
```

如上代码所示，spring会new Person，然后看到有一个属性Company，再new Company，然后设置到Person的属性上。
但是实际情况却比这个简单的实例化要复杂一些。spring的初始化可以用一个不是很恰当的例子来形容。
那就是水流。比如说水从A地点流向B地点。那么我可以在A到B中间设置3个处理器。比如：
1. 对水流起一个名字
2. 对水流进行过滤
3. 对水流进行加热
好了，现在有这三个处理器，注意这三个处理器都是我们可以对其进行增加扩展的，比如说我们可以加第四个过滤器。

这还不够，比如说2.对水流过滤。那么过滤可以分为很多，比如说，过滤水中的石子，过滤水中的微生物等等。当然这里的过滤我们也是可以扩展的。那么就是
2.1 过滤石头
2.2 过滤微生物

大家注意到没有，spring的每一层都是可以进行扩展的。你可以扩展出一个4，4里面也可以有N层。

所以这里要讲到spring的三大核心
* bean 水流
* beanFactory A地点到B地点，对水流的整体控制。
* BeanPostProcessor 我用这个来代表所有的过滤，包括一层，二层。

---

AbstractApplicationContext::refresh
* 执行：BeanFactoryPostProcessor
* 执行：BeanPostProcessor
