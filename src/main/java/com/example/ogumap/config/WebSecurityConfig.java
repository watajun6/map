package com.example.ogumap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/home", "/index", "/login/company", "/login/shop").permitAll() // 各ログインページへのアクセス許可
                .anyRequest().authenticated()                  // その他は認証を要求
            )
            .formLogin(form -> form
                .loginPage("/login/company").permitAll()       // company用ログインページ
                .loginProcessingUrl("/login/company")
                .defaultSuccessUrl("/company/home", true)
            )
            .formLogin(form -> form
                .loginPage("/login/shop").permitAll()          // shop用ログインページ
                .loginProcessingUrl("/login/shop")
                .defaultSuccessUrl("/shop/home", true)
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 仮のユーザー（実際のユーザー管理ではデータベースを使用）
        UserDetails companyUser = User.withDefaultPasswordEncoder()
            .username("companyUser")
            .password("password")
            .roles("COMPANY")
            .build();

        UserDetails shopUser = User.withDefaultPasswordEncoder()
            .username("shopUser")
            .password("password")
            .roles("SHOP")
            .build();

        return new InMemoryUserDetailsManager(companyUser, shopUser);
    }
}