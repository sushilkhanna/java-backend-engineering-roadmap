package org.demo.doctorappointment.config;

import org.demo.doctorappointment.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        // ✅ FIX #3: Allow auth service to sync users without a token
                        .requestMatchers("/api/users/sync").permitAll()

                        // ✅ FIX #7: Doctor list endpoints are accessible to all authenticated users,
                        //            not just PATIENT role — doctors and admins may also need to browse
                        .requestMatchers("/api/appointments/doctorList").authenticated()
                        .requestMatchers("/api/appointments/doctor/by-specialization/**").authenticated()

                        .requestMatchers("/api/appointments/**").hasRole("PATIENT")
                        .requestMatchers("/api/doctors/**").hasRole("DOCTOR")
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}