package ua.com.journal.student_success_journal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.journal.student_success_journal.service.UserManagerService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserManagerService userManagerService;

    @Autowired
    public WebSecurityConfig(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain spiFilterChain(HttpSecurity http) throws Exception {

        http.authenticationManager(
                http.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(userManagerService)
                        .passwordEncoder(passwordEncoder())
                        .and()
                        .build());

        http
                .csrf()
                .disable()
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/images/**", "/registration")
                        .permitAll()

                        .requestMatchers("/student", "/absence")
                        .hasRole("Student")

                        .requestMatchers("/teacher", "/group", "/Groups", "/studentDetail")
                        .hasRole("Teacher")

                        .requestMatchers("/admin", "/allStudent", "/addUser", "/allTeacher", "/adminDiscipline")
                        .hasRole("Admin")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/")
                )
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/login"));

        return http.build();
    }
}