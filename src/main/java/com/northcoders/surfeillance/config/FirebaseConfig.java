package com.northcoders.surfeillance.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);

    @Value("${firebase.config.path}")
    private String configPath;


    @PostConstruct
    public void init() {
        try {
            FileInputStream serviceAccount =  new FileInputStream("/home/jonah/Desktop/surfeillance/backend/surfeillance/src/main/resources/serviceAccountKey.json");
//            ClassPathResource resource = new ClassPathResource(configPath);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
            logger.info("App name: {}", FirebaseApp.getInstance().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}