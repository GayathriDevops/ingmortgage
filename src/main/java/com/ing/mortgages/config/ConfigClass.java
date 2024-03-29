package com.ing.mortgages.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ConfigClass extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(
						org.springframework.security.crypto.password.NoOpPasswordEncoder
								.getInstance())
				.withUser("admin").password("admin").roles("ADMIN");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/admin/**")
				.hasRole("ADMIN").and()
				.csrf().disable().headers().frameOptions().disable();
	}
}
