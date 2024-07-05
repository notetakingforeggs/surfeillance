package com.northcoders.surfeillance.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class FirebaseAuthenticationToken implements Authentication {

    private final String userName;
    private final FirebaseTokenHolder holder;
    private boolean authenticated = true;

    public FirebaseAuthenticationToken(String userName, FirebaseTokenHolder holder) {
        this.userName = userName;
        this.holder = holder;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You can customize the authorities based on your application's requirements
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Object getCredentials() {
        return holder;
    }

    @Override
    public Object getDetails() {
        return holder;
    }

    @Override
    public Object getPrincipal() {
        return userName;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return userName;
    }
}
