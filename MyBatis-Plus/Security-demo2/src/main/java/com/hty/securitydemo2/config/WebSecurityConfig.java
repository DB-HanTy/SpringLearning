package com.hty.securitydemo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                        authorize -> authorize.anyRequest().permitAll())
                .formLogin( form -> {
                    form
                            .loginPage("/login").permitAll() //登录页面无需授权即可访问
                            .usernameParameter("username") //自定义表单用户名参数，默认是username
                            .passwordParameter("password") //自定义表单密码参数，默认是password
                            .failureUrl("/login?error") //登录失败的返回地址
                            .successHandler(new MyAuthenticationSuccessHandler()) //认证成功时的处理
                            .failureHandler(new MyAuthenticationFailureHandler()); //认证失败时的处理
                }); //使用表单授权方式

        // 完整禁用CSRF和cors
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable());



        return http.build();
    }
}