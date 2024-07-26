package com.example.demo.security;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
	
//  im meomery authentication	
//	@Bean
//	public InMemoryUserDetailsManager inmemoryConfiguration()
//	{
//		
//		
//		UserDetails user1=User.builder()
//				          .username("shiva")
//				          .password("{noop}shiva1234")
//				          .roles("employee")
//				          .build();
//		
//		InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1);
//		return inMemoryUserDetailsManager;
//	}
	
	
//	// database authentication
//	@Bean
//	public UserDetailsManager configUserDetails(DataSource datasource)
//	{
//		UserDetailsManager userDetailsManager=new JdbcUserDetailsManager(datasource);
//		return userDetailsManager;
//	}
	
	
	//database and Role based Authentication
	@Bean
	public UserDetailsManager configUserDetails(DataSource datasource)
	{
		UserDetailsManager userDetailsManager=new JdbcUserDetailsManager(datasource);
		return userDetailsManager;
	}
	
	@Bean
    public SecurityFilterChain configuserdetails(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) -> {
                authorize
                    .requestMatchers(HttpMethod.GET, "/entries/**").hasAuthority("ROLE_EMPLOYEE")
                    .requestMatchers(HttpMethod.DELETE , "/entries/**").hasAuthority("ROLE_EMPLOYEE")
                    .anyRequest().authenticated();
            })
            .httpBasic(withDefaults()) // Use withDefaults() instead of .and().httpBasic()
            .csrf(csrf -> csrf.disable());
              // Use withDefaults() to replace the deprecated method
        
        return http.build();
    }

}
