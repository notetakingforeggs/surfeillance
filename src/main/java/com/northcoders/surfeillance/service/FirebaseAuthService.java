package com.northcoders.surfeillance.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.northcoders.surfeillance.config.FirebaseTokenHolder;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthService {



    public FirebaseTokenHolder parseToken(String idToken) throws Exception {
        // Verify the Firebase ID token
        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(idToken);

        // Create a FirebaseTokenHolder object to hold relevant information
        FirebaseTokenHolder tokenHolder = new FirebaseTokenHolder();
        tokenHolder.setUid(firebaseToken.getUid());
        tokenHolder.setEmail(firebaseToken.getEmail());

        return tokenHolder;
    }
}
