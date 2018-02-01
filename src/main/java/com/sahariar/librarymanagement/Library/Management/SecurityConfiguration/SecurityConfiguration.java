package com.sahariar.librarymanagement.Library.Management.SecurityConfiguration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("Select email,password,true from user where email = ?")
		.authoritiesByUsernameQuery("Select email, role from user where email = ?");
		
		
	}
   
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers("/admin2/**").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/404")
		.and()
		.formLogin().loginPage("/login")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
		.and()
		.httpBasic();
		
	}

	
	
	
}
