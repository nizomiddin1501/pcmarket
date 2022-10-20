package uz.developers.pcmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


   // SUPER_ADMIN, MODERATOR va OPERATOR

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("super_admin").password(passwordEncoder().encode("super_admin")).roles("SUPER_ADMIN")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles("MODERATOR")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles("OPERATOR");




    }


    // SUPER_ADMIN, MODERATOR va OPERATOR
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/attachment/*","/category/*","/product/*","/user/*","test/*").hasAnyRole("SUPER_ADMIN","MODERATOR","OPERATOR")
                .antMatchers(HttpMethod.POST,"/attachment/**","/category/**","/product/**","/user/**","test/**").hasAnyRole("MODERATOR","SUPER_ADMIN","OPERATOR")
                .antMatchers(HttpMethod.PUT,"/attachment/**","/category/**","/product/**","/user/**","test/**").hasAnyRole("MODERATOR","SUPER_ADMIN")
                .antMatchers("/attachment/**","/category/**","/product/**","/user/**","test/**").hasRole("SUPER_ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }




    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
