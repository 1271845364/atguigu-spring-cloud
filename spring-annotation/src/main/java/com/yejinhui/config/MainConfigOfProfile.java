package com.yejinhui.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yejinhui.bean.Yellow;

/**
 * Profile: spring为我们提供的可以根据当前环境，动态的激活和切换一些列组件的功能
 * 
 * 开发环境、测试环境、生产环境 数据源：（A）/（B）/（C）
 * 
 * @Profile 指定组件在哪个环境下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 
 * 1）、加了环境表示的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean，在任何环境下都是加载的
 * 
 * @author ye.jinhui
 * @date 2018年8月21日
 */
//@Profile("test")
@Configuration
@PropertySources(value = { @PropertySource(value = { "classpath:/dbconfig.properties" }) })
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

	private StringValueResolver resolver;

	private String driverClass;

	@Value("${db.user}")
	private String user;
	
	@Bean
	public Yellow yellow() {
		return new Yellow();
	}

//	@Profile("default")
	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("db.password") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://192.168.174.121:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("db.password") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://192.168.174.121:3306/db01");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("db.password") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://192.168.174.121:3306/db02");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver = resolver;
		driverClass = resolver.resolveStringValue(driverClass);
	}
}
