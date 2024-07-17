//package com.northcoders.surfeillance.controller;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
//import com.northcoders.surfeillance.model.dto.MessageDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtException;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
//@RestController
//@RequestMapping("oauth")
//public class OAuthController {
//
//   // private final JwtDecoder jwtDecoder;
//    private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);
//
////    public OAuthController(JwtDecoder jwtDecoder) {
////        this.jwtDecoder = jwtDecoder;
////    }
//
////
////    @GetMapping("/check")
////    public ResponseEntity<String> checkToken(@RequestParam String token) {
////        try {
////            Jwt decodedToken = jwtDecoder.decode(token);
////            // Validate the token and perform any necessary checks
////            return ResponseEntity.ok("Token is valid: " + decodedToken.getSubject());
////        } catch (JwtException e) {
////            return ResponseEntity.status(401).body("Invalid token");
////        }
////    }
//
//    @GetMapping("/hello")
//    public ResponseEntity<MessageDto> hello() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        return ResponseEntity.ok(new MessageDto("Hello " + username + "from spring boot"));
//    }
//
//
//
//}
