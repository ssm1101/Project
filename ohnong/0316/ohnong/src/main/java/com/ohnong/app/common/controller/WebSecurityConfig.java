package com.ohnong.app.common.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

	// 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(requests) -> requests
						.antMatchers("/", "/main", "/login", "/findId", "/findPw", "/join", "/css/**", "/images/**", "/js/**",
								"/bootstrap_magement/**", "/bootstrap_main/**").permitAll()//.anyRequest().authenticated()
						//.antMatchers("/member/**").hasRole("MEMBER")
						//.antMatchers("/famer").hasRole("FAMER")
						//.antMatchers("/admin/**").hasRole("ADMIN")
				)
				.formLogin((form) -> form
						.loginPage("/login")
						.defaultSuccessUrl("/main")
						.permitAll()
						.usernameParameter("userId")
						.passwordParameter("userPw")
						.successHandler(successhandler())
				)
				.logout((logout) -> logout
						.logoutSuccessUrl("/main")
						.permitAll()
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID")
				)
				.csrf().disable()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");

		return http.build();
	}
	
	@Bean
	public CustomLoginSuccessHandler successhandler() {
		return new CustomLoginSuccessHandler();
		
	}

}
