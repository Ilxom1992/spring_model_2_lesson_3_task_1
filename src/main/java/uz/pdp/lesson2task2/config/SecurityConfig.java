package uz.pdp.lesson2task2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.lesson2task2.model.AUTHORITY;
import uz.pdp.lesson2task2.model.ROLE;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("super-admin").password(passwordEncoder().encode("super-admin"))
                .roles(ROLE.SUPER_ADMIN).authorities(AUTHORITY.ADD_PRODUCT, AUTHORITY.EDIT_PRODUCT,
                AUTHORITY.DELETE_PRODUCT, AUTHORITY.READ_ALL_PRODUCT, AUTHORITY.READ_ONE_PRODUCT)
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator"))
                .roles(ROLE.MODERATOR).authorities(AUTHORITY.ADD_PRODUCT, AUTHORITY.EDIT_PRODUCT, AUTHORITY.READ_ONE_PRODUCT, AUTHORITY.READ_ALL_PRODUCT)
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator"))
                .roles(ROLE.OPERATOR).authorities(AUTHORITY.READ_ONE_PRODUCT, AUTHORITY.READ_ALL_PRODUCT);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/product").hasAuthority(AUTHORITY.ADD_PRODUCT)
                .antMatchers(HttpMethod.PUT, "/api/product/*").hasAuthority(AUTHORITY.EDIT_PRODUCT)
                .antMatchers(HttpMethod.DELETE, "/api/product/*").hasAuthority(AUTHORITY.DELETE_PRODUCT)
                .antMatchers(HttpMethod.GET, "/api/product").hasAuthority(AUTHORITY.READ_ALL_PRODUCT)
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
