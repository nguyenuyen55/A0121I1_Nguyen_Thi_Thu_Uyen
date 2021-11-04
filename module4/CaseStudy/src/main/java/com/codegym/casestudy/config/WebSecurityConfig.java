package com.codegym.casestudy.config;

import com.codegym.casestudy.service.Implement.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder encoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
    http.csrf().disable();
    //trang khong yeu cau login
        http.authorizeRequests().antMatchers("/login","logout","/homeNe").permitAll();
        http.authorizeRequests().and().formLogin().loginPage("/login");
        // Các trang yêu cầu quyền
        // http.authorizeRequests().antMatchers("/user/**").access("hasRole('Role_User')");
        http.authorizeRequests().antMatchers("/listCustomer/**","/createCustomer").access(
                "hasAnyRole('ROLE_USER','ROLE_ADMIN')");

        // Nếu access không đúng quyền, giả sử Role_User vào trang /admin/**
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/denied");
//        http.authorizeRequests().and()
//                .formLogin()
//                .defaultSuccessUrl("/user/info")
//                .and().logout()
//                .logoutSuccessUrl("/logoutSuccessful");
//        http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository()).
//                tokenValiditySeconds(60 * 60 * 10);
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }
}
