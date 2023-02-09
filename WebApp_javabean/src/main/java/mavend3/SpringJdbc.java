package mavend3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import config.SpringConfig;

public class SpringJdbc {
	private static JdbcTemplate jdbcTemplate; 
		
	static {
//		ApplicationContext context=new ClassPathXmlApplicationContext("webappconfig.xml");
//		above line works with xml file but for annotation based we use:
//		ApplicationContext context=new AnnotationConfigWebApplicationContext("SpringConfig.class");
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		jdbcTemplate=context.getBean(JdbcTemplate.class);			
		
//		ApplicationContext context2=new AnnotationConfigApplicationContext(SignupService.class);
	
		}
	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
}
