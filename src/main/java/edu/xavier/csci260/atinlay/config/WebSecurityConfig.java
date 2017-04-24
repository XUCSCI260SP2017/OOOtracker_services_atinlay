package edu.xavier.csci260.atinlay.config;

import edu.xavier.csci260.atinlay.dal.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * class WebSecurityConfig is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/12/2017.
 */

@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * allows accessing css before login
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/includes/**", "/assets/**");
    }

    /**
     * config authorization and authentication
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
           //     .passwordEncoder(passwordencoder())
                .usersByUsernameQuery(
                        "select username,password,enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from users where username=?");
    }

    /**
     * configuration for the springboot server
     *
     * @param http
     * @throws Exception
     * @Edited by Luke McNamee, orginal code provided by MkYong
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/human-resources/**").hasRole("HR")
                    .antMatchers("/manager/**").hasRole("MANAGER")
                    .and()
                .authorizeRequests()
                    .antMatchers("/", "/home", "/login").permitAll()
                    .antMatchers("/includes/**", "/assets/**").authenticated()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                    .defaultSuccessUrl("/hello", true).permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/login?logout")
                    .and()
                .csrf();
    }

    /*
    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
    */
}
