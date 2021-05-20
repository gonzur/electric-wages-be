package io.electricwages.server;

import io.electricwages.server.services.JwtService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // enable cors
        httpSecurity.cors().and().csrf().disable();

        // handle unauthorized error
        httpSecurity.exceptionHandling()
                .authenticationEntryPoint((request, response, exception) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                            exception.getMessage());
                });
        // require authorization for all but login
        httpSecurity.authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .anyRequest().authenticated();
    }

}
