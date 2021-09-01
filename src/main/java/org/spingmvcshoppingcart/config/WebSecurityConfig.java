package org.spingmvcshoppingcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springmvcshoppingcart.authenication.MyDBAuthenticationService;

@Configuration
// @EnableWebSecurity= @EnableWebMvcSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyDBAuthenticationService myDBAuthenticationService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// For user in database.
		auth.userDetailsService(myDBAuthenticationService);

	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf().disable();

		// The pages requires login as Employee or Manager.
		// If no login, it will redirect to /login page.
		httpSecurity.authorizeRequests().antMatchers("/orderList", "/order", "/accountInfo")
				.access("hasAnyRole('ROLE_EMPLOYEE','ROLE_MANAGER')");

		// For Manager Only
		httpSecurity.authorizeRequests().antMatchers("/product").access("hasRole('ROLE_MANAGER')");

		// When the user has logged in as XX
		// But access a page that requires role YY,
		// AccessDeniedException will throw.
		httpSecurity.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		httpSecurity.authorizeRequests().and().formLogin().loginProcessingUrl("j_spring_security_check") // submt URl
				.loginPage("/login").defaultSuccessUrl("/accountInfo").failureUrl("/login?error=true")
				.usernameParameter("userName").passwordParameter("password")
				// Config for logout page
				// (goto home page).
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

	}

}
