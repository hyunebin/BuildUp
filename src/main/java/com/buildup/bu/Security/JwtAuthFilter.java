package com.buildup.bu.Security;

import com.buildup.bu.Exception.Code.UserErrorCode;
import com.buildup.bu.Exception.UserException;
import com.buildup.bu.Model.Oauth.UserDto;
import com.buildup.bu.Persist.Entity.Users;
import com.buildup.bu.Repository.UserRepository;
import com.buildup.bu.Service.Oauth.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@RequiredArgsConstructor
public class JwtAuthFilter implements Filter {
    private final TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest)request).getHeader("Auth");

        if (token != null && tokenService.verifyToken(token)) {
            String email = tokenService.getUid(token);
            Users users = tokenService.findByEmail(email);

            Authentication auth = getAuthentication(users);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);
    }

    public Authentication getAuthentication(Users member) {
        return new UsernamePasswordAuthenticationToken(member, "",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}