package com.trionix.agrimartorder.security;


import com.trionix.agrimartorder.exception.UnauthorizedException;
import com.trionix.agrimartorder.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationService authService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            UserPrincipal
                    userDetails;
            UsernamePasswordAuthenticationToken
                    authentication = null;
            try {
                String header = request.getHeader(HttpHeaders.AUTHORIZATION);
                String[] bearer_s = header.split("Bearer ");


                if (bearer_s.length != 2) {
                    throw new UnauthorizedException("Token is not found");
                }
                UserPrincipal userPrincipal = authService.validateToken(bearer_s[1]);
                authentication =
                        new UsernamePasswordAuthenticationToken(userPrincipal,
                                null,
                                userPrincipal
                                        .getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                logger.info("User logged in without access token : " + e.getMessage());
                throw e;
            }
        } catch (Exception ex) {
            logger.error("User could not be authenticated in user service.", ex);
            filterChain.doFilter(request, response);
        }

    }
}
