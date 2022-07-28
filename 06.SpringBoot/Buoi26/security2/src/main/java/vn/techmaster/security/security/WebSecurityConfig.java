package vn.techmaster.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private UserDetailServiceCustom userDetailServiceCustom;

    @Autowired
    private FilterCustom filterCustom;
    @Autowired
    private AuthenticationEntryPointCustom authenticationEntryPointCustom;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServiceCustom).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/profile").hasRole("USER")
                .antMatchers("/admin/blogs").hasAnyRole("EDITOR", "ADMIN")
                .antMatchers("/admin/users").hasRole("ADMIN")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPointCustom)
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/login-custom")
                .usernameParameter("email")
                .passwordParameter("pass")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("MY_SESSION")
                .permitAll()
                .and()
                .addFilterBefore(filterCustom, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/image/**");
    }

}
