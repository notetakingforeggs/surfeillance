package com.northcoders.surfeillance.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/verifyToken")
    public String verifyToken(@RequestHeader(name = "Authorization") String idToken) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();

            return "Token is valid: " + decodedToken.getEmail();
        } catch (FirebaseAuthException e) {
            // Handle invalid tokens or exceptions
            return "Error verifying token: " + e.getMessage();
        }
    }




}
