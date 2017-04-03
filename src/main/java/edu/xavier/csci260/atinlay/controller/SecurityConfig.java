package edu.xavier.csci260.atinlay.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


/**
 * @author Rob Winch
 * @author Joe Grandja
 * @modifiedby Luke McNamee
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
			.authorizeRequests()
				.antMatchers("/", "/assets/**", "/webjars/**").permitAll()
				.antMatchers("/users/{userId}").access("@authz.check(#userId,principal)")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.httpBasic()
				.and()
			.formLogin()
				.loginPage("/")
				.permitAll()
				.and()
			.headers()
				.contentSecurityPolicy("default-src 'self' " +
						"https://ajax.googleapis.com " +
						"https://cdnjs.cloudflare.com; " +
						"style-src 'self' 'unsafe-inline'");
	}
	// @formatter:on

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}