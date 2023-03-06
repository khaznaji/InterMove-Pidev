package com.example.security.config;

import com.example.security.domain.roletype;
import com.example.security.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/user/add-user").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user//retrieve-all-usersr").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user//retrieve-user/{user-id}").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user//remove-user/{user-id}").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user/updateUser").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user/UpdatePassword/{oldPassword}/{newPassword}").hasAnyAuthority(roletype.ADMIN.name()
                        ,roletype.USER.name(),roletype.UNIVERSITY.name(), roletype.STUDENT.name(),roletype.ACCOMODATION_AGENT.name(),roletype.FORMER.name())
                .antMatchers("/auth/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.oauth2Login().and().oauth2Client().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

}
