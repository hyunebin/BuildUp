package com.buildup.bu.Security;

import com.buildup.bu.Handler.OAuth2SuccessHandler;
import com.buildup.bu.Service.Oauth.CustomOAuth2UserService;
import com.buildup.bu.Service.Oauth.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final OAuth2SuccessHandler successHandler;
    private final TokenService tokenService;

    private final CustomOAuth2UserService oAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/token/**","/signup","/signin")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()//oauth 사용
                .successHandler(successHandler)
                .userInfoEndpoint().userService(oAuth2UserService);// oauth에 대해서 oAuth2UserService로 처리한다.

        http.addFilterBefore(new JwtAuthFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/h2-console/**");
    }
}