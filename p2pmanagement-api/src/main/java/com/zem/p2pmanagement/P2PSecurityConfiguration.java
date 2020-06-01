package com.zem.p2pmanagement;

import org.springframework.context.annotation.Configuration;//
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class P2PSecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Management of Users and Roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		       .withUser("zem").password("password").roles("USER").and()
		       .withUser("admin").password("admin").roles("ADMIN");
	}
	
	// Management of URLs access
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		    .and()
		         .authorizeRequests()
		            .antMatchers(HttpMethod.POST,     "/XXXclients").hasRole("ADMIN")
		            .antMatchers(HttpMethod.PUT,   "/XXXclients/**").hasRole("ADMIN")
		            .antMatchers(HttpMethod.PATCH, "/XXXclients/**").hasRole("ADMIN")
		    .and()
		         .csrf().disable();
	}

}
