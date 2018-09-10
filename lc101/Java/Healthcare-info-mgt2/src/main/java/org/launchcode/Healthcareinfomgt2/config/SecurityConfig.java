package org.launchcode.Healthcareinfomgt2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    CustomSuccessHandler customSuccessHandler;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//
//        System.out.println("In configure AuthenticationManagerBuilder");
//        auth.
//                jdbcAuthentication()
//                .usersByUsernameQuery(usersQuery)
//                .authoritiesByUsernameQuery(rolesQuery)
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder());
//    }

    // Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println("In configure HttSecurity");
//        http.
//                authorizeRequests()
//                .antMatchers("/healthcare-info-mgt").permitAll()
//                .antMatchers("/healthcare-info-mgt/login").permitAll()
//                .antMatchers("/healthcare-info-mgt/signup").permitAll()
//                .antMatchers("/healthcare-info-mgt/doctor/**").hasAuthority("Doctor")
//                .antMatchers("/healthcare-info-mgt/patient/**").hasAuthority("Patient")
//                .and().formLogin().loginPage("/healthcare-info-mgt/login").successHandler(customSuccessHandler)
//                .usernameParameter("userName")
//                .passwordParameter("password")
//
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied");

        http.authorizeRequests()
                .antMatchers("/healthcare-info-mgt").permitAll()
                .antMatchers("/healthcare-info-mgt/signup").permitAll()
//                .antMatchers("/healthcare-info-mgt/patient/**").hasAnyRole("Patient").anyRequest().authenticated()
                .antMatchers("/healthcare-info-mgt/personal/**/**").hasAnyAuthority("Doctor", "Patient").anyRequest().authenticated()
                .and().formLogin().successHandler(customSuccessHandler)
                .loginPage("/healthcare-info-mgt/login").permitAll()
                .usernameParameter("userName")
                .passwordParameter("password")
                .and().logout().permitAll();

        http.csrf().disable();

        http.logout()
             .logoutRequestMatcher(new AntPathRequestMatcher("/healthcare-info-mgt/logout"))
                .logoutSuccessUrl("/healthcare-info-mgt/login").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
