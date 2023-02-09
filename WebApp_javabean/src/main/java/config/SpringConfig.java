package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//means above code replaces beans created in xml file 
//Spring Configuration annotation indicates that the class has @Bean definition methods. 
//So Spring container can process the class and generate Spring Beans to be used in the application.
public class SpringConfig {
	
	//now creating bean with method
	//first one is of datasource, spring method for jdbc to create connection to mysql table
	/*
	<bean name="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver" />
    <property name="url" value="jdbc:mysql://localhost:3306/cubic" />
    <property name="username" value="root" />
    <property name="password" value="root" />
    <!-- update the names of  driverclassname, url, un and pw as per facts-->
	</bean>
	*/
	
	@Bean
	public DriverManagerDataSource createDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/cubic");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	/* Now for this bean
	*<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    *<property name="dataSource" ref="dataSource"/>
	*</bean>
	 * 
	*/
	
	@Bean
	public JdbcTemplate createJdbcTemplate() {          //or createJdbcTemplate
		return new JdbcTemplate(createDataSource());
		
	}
	
}
