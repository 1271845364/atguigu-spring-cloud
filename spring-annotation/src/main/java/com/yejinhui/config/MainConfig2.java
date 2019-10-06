package com.yejinhui.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.yejinhui.bean.Color;
import com.yejinhui.bean.ColorFactoryBean;
import com.yejinhui.bean.Person;
import com.yejinhui.bean.Red;
import com.yejinhui.condition.LinuxCondition;
import com.yejinhui.condition.MyImportBeanDefinitionRegistrar;
import com.yejinhui.condition.MyImportSelector;
import com.yejinhui.condition.WindowsCondition;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
//满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional(value={WindowsCondition.class})
@Configuration
@Import(value={Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
//导入组件，id默认是组件的全类名
public class MainConfig2 {

	/**
	 * @Scope：调整作用域
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON	singleton
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST	request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
	 * @return
	 * 
	 * prototype	多实例：ioc容器并不会去调用方法创建对象放在容器中
	 * 				每次获取的时候才会调用方法创建对象
	 * singleton	单实例(默认值):ioc容器启动会调用方法创建对象放到ioc容器中
	 * 				以后每次获取就是直接从容器(map.get())中拿
	 * request		同一个请求创建一个实例
	 * session		同一个session创建一个实例
	 * 
	 * 懒加载：
	 * 		单实例bean：默认在容器启动的时候创建对象
	 * 		懒加载：容器启动的时候不创建对。第一次使用(获取)Bean创建对象，并初始化
	 */
	//默认是单实例
//	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Lazy
	@Bean("person")
	public Person person() {
		System.out.println("给容器添加Person...");
		return new Person("张三", 25);
	}
	
	/**
	 * @Conditional({Condition})：按照一定条件进行判断，满足条件给容器中注册bean
	 * 
	 * 如果系统是windows，就给容器注册("bill")
	 * 如果系统是linux，就给容器注册("linus")
	 */
//	@Conditional(value={WindowsCondition.class})
	@Bean("bill")
	public Person person01() {
		return new Person("Bill Gates", 62);
	}
	
	@Conditional(value={LinuxCondition.class})
	@Bean("linus")
	public Person person02() {
		return new Person("linus", 48);
	}
	
	/**
	 * 给容器中注册组件：
	 * 	1).包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)[局限于自己写的类]
	 *  2).@Bean[导入的第三方包里面的组件]
	 *  3).@Import[快速给容器中导入一个组件]
	 *  	1).@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
	 *   	2).ImportSelector：返回需要导入的组件的全类名数组		springboot源码中用的最多
	 *   	3).ImportBeanDefinitionRegistrar：手动注册bean到容器中
	 *  4).使用Spring提供的FactoryBean(工厂Bean)	FactoryBean在与其他框架整合用的时候特别多
	 *  	1).默认获取到的是工厂bean调用getObject创建的对象
	 *  	2).获取工厂Bean本身，我们需要给id前面加上一个&
	 *  		例如：&colorFactoryBean
	 *  
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
