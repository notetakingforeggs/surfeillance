package com.northcoders.surfeillance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
//    private String jwkSetUri;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/oauth/login", "/oauth2/**", "/error","/oauth/check").permitAll();
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(oauth2 -> oauth2
                        //.loginPage("/oauth/login")
                        .defaultSuccessUrl("/oauth/dashboard", true)
                )

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2ResourceServer().jwt().decoder(jwtDecoder())
                .and()
                .and()
                .cors()
                .and().csrf().disable()
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .jwsAlgorithm(SignatureAlgorithm.RS256).build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(googleClientRegistration());
    }

    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("google")
                .clientId("1026399556068-dlotbonspvqtnen0t43k2o5dmnhf7v39.apps.googleusercontent.com")
                .clientSecret("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")
                .scope("openid", "profile", "email")
                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("http://localhost:8080/oauth/dashboard")
                .tokenUri("https://oauth2.googleapis.com/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .clientName("Google")
                .build();
    }

//    @Bean
//    public OidcUserService oidcUserService() {
//        OidcUserService oidcUserService = new OidcUserService();
//        oidcUserService.setOauth2UserService(oAuth2UserService());
//        return oidcUserService;
//    }
//
//    @Bean
//    public DefaultOAuth2UserService oAuth2UserService() {
//        return new CustomOAuth2UserService();
//    }
}
