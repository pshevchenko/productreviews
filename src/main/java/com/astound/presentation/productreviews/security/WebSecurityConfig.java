package com.astound.presentation.productreviews.security;

import com.astound.presentation.productreviews.services.CustomerDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers( "/products/**", "/registration", "/css/**", "/js/**", "/img/**", "/favicon.ico").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/support/**").access("hasRole('SUPPORT') and hasRole('ADMIN')")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .successHandler((req,res,auth) -> {
                        req.getSession().setAttribute("username", auth.getName());
                        res.sendRedirect("/");
                    })
                    .failureHandler((req,res,exc) -> {
                        req.getSession().setAttribute("message", getErrorMessage(exc));
                        res.sendRedirect("/login");
                    })
                .permitAll()
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessHandler((req,res,auth) -> {   // Logout handler called after successful logout
                        req.getSession().setAttribute("message", "You are logged out successfully.");
                        res.sendRedirect("/login"); // Redirect user to login page with message.
                    })
                .permitAll()
                .and()
                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        ;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomerDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private String getErrorMessage(AuthenticationException exc) {
        return exc.getClass().isAssignableFrom(BadCredentialsException.class) ? "Invalid username or password." : "Unknown error - "+exc.getMessage();
    }
}
