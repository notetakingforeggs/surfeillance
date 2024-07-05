package com.northcoders.surfeillance.config;

import com.google.firebase.auth.FirebaseToken;
import com.northcoders.surfeillance.service.FirebaseAuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

public class FirebaseFilter extends OncePerRequestFilter {

    private static final String HEADER_NAME = "Authorization";
    private final FirebaseAuthService firebaseService;

    public FirebaseFilter(FirebaseAuthService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

                String xAuth = request.getHeader(HEADER_NAME);
        if (StringUtils.isBlank(xAuth) || !xAuth.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String idToken = xAuth.substring(7); // Extract token without 'Bearer ' prefix

        try {
            FirebaseTokenHolder holder = firebaseService.parseToken(idToken);

            String userName = holder.getUid();

            Authentication auth = new FirebaseAuthenticationToken(userName, holder);
            SecurityContextHolder.getContext().setAuthentication(auth);

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid or expired token");
        }

    }


//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String xAuth = request.getHeader(HEADER_NAME);
//        if (StringUtils.isBlank(xAuth) || !xAuth.startsWith("Bearer ")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String idToken = xAuth.substring(7); // Extract token without 'Bearer ' prefix
//
//        try {
//            FirebaseTokenHolder holder = firebaseService.parseToken(idToken);
//
//            String userName = holder.getUid();
//
//            Authentication auth = new FirebaseAuthenticationToken(userName, holder);
//            SecurityContextHolder.getContext().setAuthentication(auth);
//
//            filterChain.doFilter(request, response);
//        } catch (Exception e) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("Invalid or expired token");
//        }
//    }
}
