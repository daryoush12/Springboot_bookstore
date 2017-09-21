package com.haagaprojects.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.haagaprojects.bookstore.web.*;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	  private UserDetailsServiceImpl userDetailsService;	
	 
protected void configure(HttpSecurity http)throws Exception{
	//Give everyone permission to use css. Otherwise redirection will fail:
	http
	.authorizeRequests().antMatchers("/css/**").permitAll()
    .and()
	.authorizeRequests()
	.antMatchers("/book/","/add/").hasAuthority("USER")
	.and()
	.authorizeRequests()
	.antMatchers("/book/","/add/").hasAuthority("ADMIN")
	.and()
	.authorizeRequests().anyRequest().authenticated()
	.and()
	.formLogin()
	.loginPage("/login")
	.defaultSuccessUrl("/book")
	.permitAll()
	.and()
	.logout()
	 .permitAll();
}
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
//	.inMemoryAuthentication()
////	.withUser("admin").password("password").roles("USER");
////	auth
////	.inMemoryAuthentication()
////	.withUser("user").password("password").roles("ADMIN");
////	auth
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(new BCryptPasswordEncoder());
}


}
