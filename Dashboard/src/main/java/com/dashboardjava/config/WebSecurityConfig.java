package com.dashboardjava.config;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	

	@Resource(name = "userService")
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}



	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(encoder());
	}

	@Bean
	public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
		/* .antMatchers(HttpMethod.OPTIONS,"/path/to/allow").permitAll()*/
		.antMatchers("/dashboard/**").permitAll()
		
		//allowing methods to be accessed without authentication
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http
		.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
		System.out.println("inside void configure");
		
		
	}

	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	

	    
	/*@Bean
    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {
        return emf.unwrap(SessionFactory.class);
    }
	 */



	/*@PersistenceContext
    private EntityManager entityManager;

    @Bean
    public SessionFactory getSessionFactory() {
         return entityManager.unwrap(SessionFactory.class);
    }
	 */




}
