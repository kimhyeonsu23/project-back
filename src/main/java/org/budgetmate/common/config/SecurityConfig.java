package org.budgetmate.common.config;

import org.budgetmate.common.jwt.JwtAuthenticationFilter;
import org.budgetmate.common.jwt.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // 추가!
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity 
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, JwtUtil jwtUtil) throws Exception {
		System.out.println("[SecurityConfig] 필터 체인 설정 시작");
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	        		.requestMatchers("/api/users/signup", "/api/users/login").permitAll()
	        		.requestMatchers("/api/users/me").authenticated()  // ✅ 수정
	        		.anyRequest().authenticated()
	        )
	        .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
	        .formLogin(login -> login.disable())
	        .httpBasic(basic -> basic.disable());

	    return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
