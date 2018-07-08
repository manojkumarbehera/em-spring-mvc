package com.manojbehera.emsm.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.manojbehera.emsm.persistence.UserRepository;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EmSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	public EmSecurityConfig() {
		super();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider);
	}

	/*
	 * @PostConstruct private void saveSomeUser() {
	 * 
	 * System.out.println("******************"); final User user = new User();
	 * user.setEmail("xyz@gmail.com"); //user.setPassword("pass");
	 * user.setPassword(passwordEncoder().encode("pass"));
	 * userRepository.save(user);
	 * 
	 * }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {

		// return new StandardPasswordEncoder();
		// return new StandardPasswordEncoder("MySecretKey");
		return new BCryptPasswordEncoder(12);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/about", "/login", "/signup", "/user/register").permitAll()
				// .antMatchers("/delete/*").hasRole("ADMIN")
				.anyRequest().authenticated()

				.and().formLogin().loginPage("/login").permitAll().loginProcessingUrl("/doLogin")
				.successForwardUrl("/user/welcome")
				// .failureUrl("/<uri>")

				.and().logout().permitAll().logoutUrl("/logout")
				// .logoutSuccessUrl("/login")
				.and().csrf().disable();
	}

	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

		@Override
		public MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
			final Map<String, List<ConfigAttribute>> methodMap = new HashMap<>();
			methodMap.put("com.manojbehera.emsm.web.controller.UserController.createForm*",
					SecurityConfig.createList("ROLE_ADMIN"));
			return new MapBasedMethodSecurityMetadataSource(methodMap);
		}

	}

}
