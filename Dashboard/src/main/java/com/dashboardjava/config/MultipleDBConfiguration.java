package com.dashboardjava.config;


	import javax.sql.DataSource;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Qualifier;
	import org.springframework.boot.context.properties.ConfigurationProperties;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.Primary;
	import org.springframework.core.env.Environment;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;


	@Configuration
	public class MultipleDBConfiguration {
	          @Autowired
	    private Environment env;
	          @Bean
	    @Primary
	    @ConfigurationProperties(prefix = "spring.datasource")
	          public DataSource firstDataSource() {
	        	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        	  dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
	        	  dataSource.setUrl(env.getProperty("spring.datasource.url"));
	        	  dataSource.setUsername(env.getProperty("spring.datasource.username"));
	        	  dataSource.setPassword(env.getProperty("spring.datasource.password"));
	        	  return dataSource;
	          }

	    @Bean(name="secondDataSource")
	    @ConfigurationProperties(prefix = "spring.hrms")
	    public DataSource secondDataSource() {
	          DriverManagerDataSource dataSource = new DriverManagerDataSource();
	              dataSource.setDriverClassName(env.getProperty("spring.hrms.driverClassName"));
	              dataSource.setUrl(env.getProperty("spring.hrms.url"));
	              dataSource.setUsername(env.getProperty("spring.hrms.username"));
	              dataSource.setPassword(env.getProperty("spring.hrms.password"));
	        return dataSource;
	    }
	  
	    
	    @Bean(name="thirdDatasource")
	    @ConfigurationProperties(prefix = "spring.x0")
	    public DataSource thirdDatasource() {
	          DriverManagerDataSource dataSource = new DriverManagerDataSource();
	              dataSource.setDriverClassName(env.getProperty("spring.x0.driverClassName"));
	              dataSource.setUrl(env.getProperty("spring.x0.url"));
	              dataSource.setUsername(env.getProperty("spring.x0.username"));
	              dataSource.setPassword(env.getProperty("spring.x0.password"));
	        return dataSource;
	    }
	    
	    @Bean(name="fourthDatasource")
	    @ConfigurationProperties(prefix = "spring.finance")
	    public DataSource fourthDatasource() {
	          DriverManagerDataSource dataSource = new DriverManagerDataSource();
	              dataSource.setDriverClassName(env.getProperty("spring.finance.driverClassName"));
	              dataSource.setUrl(env.getProperty("spring.finance.url"));
	              dataSource.setUsername(env.getProperty("spring.finance.username"));
	              dataSource.setPassword(env.getProperty("spring.finance.password"));
	        return dataSource;
	    }
	    
	    
	    
	    
	    
	    @Bean(name="financeTemplate")
	    public JdbcTemplate jdbcTemplatefinance(@Qualifier("fourthDatasource") DataSource ds) {
	        return new JdbcTemplate(ds);
	    }
	    
	    
	    @Bean(name="hrmsTemplate")
	    public JdbcTemplate jdbcTemplatehrms(@Qualifier("secondDataSource") DataSource ds) {
	        return new JdbcTemplate(ds);
	    }
	    
	    @Bean(name="x0Template")
	    public JdbcTemplate jdbcTemplatex0(@Qualifier("thirdDatasource") DataSource ds) {
	        return new JdbcTemplate(ds);
	    }
	    
	    @Bean(name="spring.datasource")
	    public JdbcTemplate jdbcTemplatesyntranet(@Qualifier("firstDataSource") DataSource ds) {
	        return new JdbcTemplate(ds);
	    }
	    
//	    @Bean
//	    public JdbcTemplate jdbcTemplateSkillbay(@Qualifier("skillBayDataSource") DataSource ds) {
//	        return new JdbcTemplate(ds);
//	    }
//	    @Bean
//	    public JdbcTemplate jdbcTemplate(@Qualifier("firstDataSource") DataSource ds) {
//	        return new JdbcTemplate(ds);
//	    }
//	    @Bean(name="financeTemplate")
//	    public JdbcTemplate jdbcTemplateFinance(@Qualifier("financeDataSource") DataSource ds) {
//	          return new JdbcTemplate(ds);
//	    }
//
//	    
//	    @Bean(name="hrmsTemplate")
//	    public JdbcTemplate jdbcTemplateHrms(@Qualifier("hrmsDataSource") DataSource ds) {
//	        return new JdbcTemplate(ds);
//	    }
//
//	          @Bean
//	    public JdbcTemplate jdbcTemplateMaster(@Qualifier("masterDataSource") DataSource ds) {
//	        return new JdbcTemplate(ds);
//	    }
	}



