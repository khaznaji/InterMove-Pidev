package com.example.intermove.Configurations;

import com.example.intermove.Entities.User.roletype;
import com.example.intermove.Security.JwtAuthenticationFilter;
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



                .antMatchers("/quiz/addQuiz").permitAll()
                .antMatchers("/quiz/addQuestionToQuiz/{{idQuiz}}").permitAll()
                .antMatchers("/quiz/addResponseToQuestion/{questionId}/{studentId}").permitAll()
                .antMatchers("/quiz/diplayShuffledQuestionOfQuiz/{idQuiz}").permitAll()
                .antMatchers("/quiz/displayUsersByScore").permitAll()
                .antMatchers("/quiz/displayQuiz").permitAll()
                .antMatchers("/quiz/displayQuestion").permitAll()
                .antMatchers("/quiz/displayResponse").permitAll()
                .antMatchers("/quiz/deleteQuiz/{{idQuiz}}").permitAll()
                .antMatchers("/quiz/updateQuiz").permitAll()
                .antMatchers("/quiz/deleteQuestion/{{idQuestion}}").permitAll()






                .antMatchers("/user/add-user").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user//retrieve-all-usersr").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user//retrieve-user/{user-id}").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user//remove-user/{user-id}").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user/updateUser").hasAuthority(roletype.ADMIN.name())
                .antMatchers("/user/UpdatePassword/{oldPassword}/{newPassword}").hasAnyAuthority(roletype.ADMIN.name()
                        ,roletype.USER.name(),roletype.UNIVERSITY.name(), roletype.STUDENT.name(),roletype.ACCOMODATION_AGENT.name(),roletype.FORMER.name())
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/location").permitAll()
                .antMatchers("/Events/videochat2").permitAll()
                .antMatchers("/Claim/room").permitAll()

                .antMatchers("/Events/add").permitAll()
                .antMatchers("/Events/list").permitAll()
                .antMatchers("/Events/updateEvents/{{id}}").permitAll()
                .antMatchers("/Events/delete/{{id}}").permitAll()
                .antMatchers("/Events/getEventsbyid/{{id}}").permitAll()
                .antMatchers("/Events/getEventsbyTitle/{{title}}").permitAll()
                .antMatchers("/Events/affecter-user-event/{{id}}/{{idE}}").permitAll()
                .antMatchers("/Events/remove-user-event/{{id}}/{{idE}}").permitAll()
                .antMatchers("/Events").permitAll()
                .antMatchers("/Events/{{id}}").permitAll()
                .antMatchers("/Events/events/{{eventId}}/share/facebook").permitAll()
                .antMatchers("/Events/export").permitAll()
                .antMatchers("/Events/video-feed").permitAll()
                .antMatchers("/Claim/reclamation/{{id}}").permitAll()
                .antMatchers("/Claim/updateComplaintAdmin/{{id}}").permitAll()
                .antMatchers("/Claim/updateComplaint/{{id}}").permitAll()
                .antMatchers("Claim/list").permitAll()
                .antMatchers("/Claim/delete/{{id}}").permitAll()
                .antMatchers("/Claim/getClaimbyid/{{id}}").permitAll()
                .antMatchers("/Claim/getStatus/{{status}}").permitAll()
                .antMatchers("/Claim/mostcomplainer").permitAll()
                .antMatchers("/Claim/duplicatecomplainers").permitAll()
                .antMatchers("/Claim/{{id}}/send-email").permitAll()
                .antMatchers("/twilio/make-call/{{userId}}").permitAll()
                .antMatchers("/chat/**").permitAll() // New rule added to permit access to /chat endpoint
                .anyRequest().authenticated()
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
