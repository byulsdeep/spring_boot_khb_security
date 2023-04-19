package edu.global.ex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.global.ex.security.CustomUserDetailsService;

@Configuration // @Component + 의미(설정할 수 있는 파일)
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 우선 CSRF 설정을 해제한다.
		// 초기 개발시만 해주는게 좋다.
		http.csrf().disable();

		http.authorizeRequests()
			.antMatchers("/user/**").hasAnyRole("USER")
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/**").permitAll();

		http.formLogin() // 스프링 시큐리티에 있는 기본 로그인 폼을 사용하겠다.
			.loginPage("/login")
			.usernameParameter("id")
			.usernameParameter("pw")
			.permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.inMemoryAuthentication()
//			.withUser("user").password("{noop}user").roles("USER").and()
//			.withUser("admin").password("{noop}admin").roles("ADMIN");
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
