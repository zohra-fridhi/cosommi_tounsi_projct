package tn.esprit.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

		@Qualifier("userDetailsServiceImpl")
		@Autowired
		// Make sure to import the spring security interface
				UserDetailsService userDetailsService;

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http
					.authorizeRequests()
					.antMatchers("/api/auth/login/**").permitAll()
					.antMatchers("/api/**").authenticated()
					.and().httpBasic().and().logout();
			http.csrf().disable();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// Set your configuration on the auth object
			auth.userDetailsService(userDetailsService);
		}

//		@Bean
//		public PasswordEncoder getPasswordEncoder() {
//			return NoOpPasswordEncoder.getInstance();
//		}
		
		
	    
	}

