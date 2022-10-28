package com.eukolos.restaurant.security;

import com.eukolos.restaurant.service.UserDetailsServiceImpl;
import com.eukolos.restaurant.utils.TokenGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final TokenGenerator tokenGenerator;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtFilter(TokenGenerator tokenGenerator, UserDetailsServiceImpl userDetailsService) {
        this.tokenGenerator = tokenGenerator;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        String username;
        try {
            if(!token.isBlank()){
                username = tokenGenerator.verifyJWT(token).getSubject();
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            filterChain.doFilter(request,response);
        }
        catch (Exception e) {
            response.setContentType("application/json");
            Map<String,String> errors = new HashMap<>();
            errors.put("error",e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(errors));
        }
    }

    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header==null || !header.startsWith("Bearer ")){
            return "";
        }
        return header.substring(7);
    }
}
