package com.northcoders.surfeillance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oauth")
public class OAuthController {

    private final JwtDecoder jwtDecoder;

    public OAuthController(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }


    @GetMapping("/check")
    public ResponseEntity<String> checkToken(@RequestParam String token) {
        try {
            Jwt decodedToken = jwtDecoder.decode(token);
            // Validate the token and perform any necessary checks
            return ResponseEntity.ok("Token is valid: " + decodedToken.getSubject());
        } catch (JwtException e) {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }



}
