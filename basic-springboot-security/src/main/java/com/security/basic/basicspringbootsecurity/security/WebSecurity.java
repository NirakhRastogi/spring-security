package com.security.basic.basicspringbootsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index.html")
                .permitAll()
                .antMatchers("/admin/*").hasRole(ApplicationRoles.ADMIN.name())
                .antMatchers("/user/read/*").hasAuthority(ApplicationPermission.READ.getPermission())
                .antMatchers("/user/**/*").hasRole(ApplicationRoles.USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("password"))
                        .authorities(ApplicationRoles.ADMIN.getAuthorities())
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("password"))
                        .authorities(ApplicationRoles.USER.getAuthorities())
                        .build(),
                User.builder()
                        .username("usertrainee")
                        .password(passwordEncoder.encode("password"))
                        .authorities(ApplicationRoles.USERTRAINEE.getAuthorities())
                        .build()
        );
    }
}
