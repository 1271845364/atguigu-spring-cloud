package com.yejinhui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.yejinhui.bean.Car;
import com.yejinhui.bean.Color;
import com.yejinhui.dao.BookDao;

/**
 * 自动装配：
 * 		spring利用依赖注入(DI)，完成对ioc容器中各个组件的依赖关系赋值
 * 
 * 1）、 @Autowired：自动注入：
 * 		1）、默认按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class);找到就赋值
 * 		2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 * 								applicationContext.getBean("bookDao");
 * 		3）、 @Qualifier(value="bookDao")；使用 @Qualifier指定需要装配的组件的id，而不是使用属性名
 * 		4）、自动装配默认一定要将属性赋值好，没有找到就会报错
 * 			可以使用 @Autowired(required=false)
 * 		5）、 @Primary：让spring进行自动装配的时候，默认使用首选的bean
 * 					也可以继续使用 @Qualifier 指定需要装配的bean的名字
 * 		BookService{
 * 			@Autowired
 * 			BookDao bookDao;
 * 		}
 * 
 * 2）、spring还支持使用 @Resoure(JSR250规范的)和@Inject(JSR330规范)[java规范的注解]
 * 		@Resource:
 * 			可以和 @Autowired 一样实现自动装配功能；默认是按照组件名称进行装配的
 * 			没有能支持 @Primary 功能，也不支持 @Autowired(required=false)功能
 * 		@Inject:
 * 			需要导入javax.inject的包，和Autowired的功能一样。没有required=false功能
 * 	@Autowired 是spring定义的； @Resource 、 @Inject 都是java的规范
 *  AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能		
 *  
 *  3）、 @Autowired ：构造器、参数、方法、属性
 *  		1）、[标准在方法位置]: @Bean + 方法参数；参数从容器中获取；默认不写 @Autowired ，效果是一样的，都能自动装配
 *  		2）、[标在构造器上]：如果只有一个有参构造器，这个有参构造器的 @Autowired 可以省略，参数位置的组件还是可以自动从容器中获取的
 *  		3）、[放在参数位置]
 *  
 *  4）、自定义组件如果想要使用spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）
 *  		自定义组件实现xxxAware接口，会调用接口
 *  		把spring底层一些组件注入到自定义的bean中
 *  		xxxAware：功能使用xxxProcessor:
 *  			ApplicationContextAware ==> ApplicationContextAwareProcessor				
 * 
 * @author ye.jinhui
 * @date 2018年8月20日
 */
@Configuration
@ComponentScan(basePackages={"com.yejinhui.service","com.yejinhui.dao","com.yejinhui.controller","com.yejinhui.bean"})
public class MainConfigOfAutowired {

	@Primary
	@Bean(value="bookDao2")
	public BookDao bookDao() {
		BookDao bookDao = new BookDao();
		bookDao.setLabel("2");
		return bookDao;
	}
	
	/**
	 * @Bean 标注的方法的创建对象的时候，方法的参数是从容器中获取
	 * 
	 * @return
	 */
	@Bean
	public Color color(Car car) {
		Color color = new Color();
		color.setCar(car);
		return color;
	}
	
}
