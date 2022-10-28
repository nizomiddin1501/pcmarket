package uz.developers.pcmarket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // SUPER_ADMIN, MODERATOR va OPERATOR

    private final PasswordEncoder passwordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole(UserRole.OPERATOR.name(),UserRole.MODERATOR.name(),UserRole.SUPER_ADMIN.name())
                .antMatchers(HttpMethod.POST,"/api/**").hasAnyRole(UserRole.OPERATOR.name(),UserRole.MODERATOR.name(),UserRole.SUPER_ADMIN.name())
                .antMatchers(HttpMethod.PUT,"/api/**").hasAnyRole(UserRole.MODERATOR.name(),UserRole.SUPER_ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/api/**").hasAnyRole(UserRole.SUPER_ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails operator = User.builder()
                .username("operator")
                .password(passwordEncoder.encode("operator"))
                .roles(UserRole.OPERATOR.name()) //ROLE_OPERATOR
                .build();

        UserDetails moderator = User.builder()
                .username("moderator")
                .password(passwordEncoder.encode("moderator"))
                .roles(UserRole.MODERATOR.name()) //ROLE_MODERATOR
                .build();

        UserDetails super_admin = User.builder()
                .username("super_admin")
                .password(passwordEncoder.encode("super_admin"))
                .roles(UserRole.SUPER_ADMIN.name()) //ROLE_SUPER_ADMIN
                .build();


        return new InMemoryUserDetailsManager(
                operator,
                moderator,
                super_admin

        );
    }
}
