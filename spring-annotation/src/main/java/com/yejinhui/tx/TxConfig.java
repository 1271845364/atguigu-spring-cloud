package com.yejinhui.tx;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 声明式事务：
 * 
 * 环境搭建：
 * 1、导入相关依赖
 * 		数据源、数据库驱动、spring-jdbc模块
 * 2、配置数据源、JdbcTemplate（Spring提供的简化数据库操作的工具）操作数据
 * 3、给方法上标注 @Transactional 表示当前方法是一个事务方法
 * 4、 @EnableTransactionManagement 开启基于注解的事务管理功能
 * 		@EnableXXX
 * 5、配置事务管理器来控制事务 
 * 		@Bean
 * 		public DataSourceTransactionManager transactionManager()
 * 
 *  原理：
 *    1）、 @EnableTransactionManagement 	
 *    		利用 TransactionManagementConfigurationSelector给容器中会导入组件 
 *  		导入两个组件
 *  		AutoProxyRegistrar
 *  		ProxyTransactionManagementConfiguration
 *    2）、AutoProxyRegistrar：
 *    		给容器中注册一个 InfrastructureAdvisorAutoProxyCreator 组件
 *    		InfrastructureAdvisorAutoProxyCreator；？
 *    		利用后置处理器机制在对象创建后，包装对象，返回一个代理对象（增强器），代理对象执行方法利用拦截器链进行调用；		
 *    
 *    3）、ProxyTransactionManagementConfiguration 做了什么？
 *    	     a）、给容器中注册事务增强器
 *    			1）、事务增强器要用事务注解的信息，AnnotationTransactionAttributeSource 解析事务注解		
 *				2）、事务拦截器：
 *					TransactionInterceptor；保存了事务属性信息，事务管理器	
 *					他是一个 MethodInterceptor；
 *					在目标方法执行的时候；
 *						执行拦截器链；
 *						事务拦截器；
 *							1）、先获取事务相关属性
 *							2）、再获取 PlatformTransactionManager ，如果事先没有添加指定任何的transactionManager
 *								最终会从容器中按照类型获取一个 PlatformTransactionManager ；
 *							3）、执行目标方法
 *								如果异常，获取事务管理器，利用事务管理器回滚操作	
 *								如果正常，利用事务管理器，提交事务
 *					
 *    
 *    
 * @author ye.jinhui
 * @date 2018年8月24日
 */
@EnableTransactionManagement
@ComponentScan(value={"com.yejinhui.tx"})
@Configuration
public class TxConfig {

	//数据源
	@Bean
	public DataSource dataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://192.168.174.121:3306/test");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) throws Exception {
		//Spring容器会对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都是从容器中找组件
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	//注册事务管理器在容器中
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
