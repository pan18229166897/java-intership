# 高频出现的问题

1. 接口和抽象类的区别
    1. 接口可以实现`多继承`
    1. 抽象类有`构造器`，接口没有
    1. 抽象类的子类使用`extends`关键字继承，接口子类使用`implements`实现接口
    1. 抽象方法可以有默认的方法实现，**接口完全是抽象的，不存在方法的实现**

    ``` java
    //抽象类
    public abstract class Test extends Parent {
        public Test(){
            
        }
        //抽象方法
        public abstract int functionA(int a, int b);
        
        public int functionB(int a, int b){
            return a + b;
        }
    }

    //接口
    public interface TestInterface {
        //only public, static & final are permitted
        //private static String a;
        
        //The blank final field a may not have been initialized
        //public static final String a;
        
        public static final String a = "TEST";
        
        public void eat();
    }
    ```


2. 控制反转和依赖注入

    控制反转指的是程序中对象的创建交由`ioc容器`，程序只需要被动的接收，对象交给ioc容器控制，反转是指`对象的创建权得到反转`依赖注入当a类中使用了b类的对象，这就形成了依赖关系，因为现在对象交给容器创建，那么依赖关系也交给容器进行维护，通过容器中的`setter`方法，为属性注入一个对应的对象

    > 利用`元注解`方式实现 @Autowired
    >> 通过@Autowired自动装配方式，从IoC容器中去查找到，并返回给该属性

    ``` xml
     <!-- 事务管理器 -->
    <bean id="transManager"
        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="ds"></property>
    </bean>

    <!-- 扫描sql映射,并自动byType注入dao -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="sqlSessionFactoryBeanName" value="ssf"></property>
        <property name="basePackage" value="dao"></property>
    </bean>
    ```

    ``` java
    @RestController    //使用RestController则无法返回jsp和html页面，专门用于返回json
    @RequestMapping("/bill") //解析后台url时使用，相当于地址映射到的方法位置
    public class BillAction {
        @Autowired   //自动装配方式，从IoC容器中去查找到，并返回给该属性
	    private BillBiz billbiz;
    }
        
    ```
   

3. 什么是aop
   aop就是面向切面编程，是一种横向编程方式，将散落在程序中核心业务模块的
   公用代码抽取出来，组装成一个可以重用的模块，这个模块叫切面，然后通过
   横向编程，打开程序内部，将切面以动态代理的方式植入

4. 线程池
   线程池就是，当有一个线程开启时会往线程池队列中添加一个线程，之后的线程
   都会按顺序进行排列，当线程调用run方法时，按CPU的想法执行线程，线程不能
   超过线程池最大数，当超过线程最大数后会在线程池外排队。

