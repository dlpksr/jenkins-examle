package net.codejava.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.codejava.contact.dao.ContactDao;
import net.codejava.contact.dao.ContactDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.codejava.contact")

public class SpringMvcConfig implements WebMvcConfigurer {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("lakshmi");
		dataSource.setPassword("Visa@20");
		return dataSource;

	}

	@Bean
	public ViewResolver getViewResolver() {	
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;

	}

	@Bean
	public ContactDao getContactDao() {
		return new ContactDaoImpl(getDataSource());

		

	}
}
