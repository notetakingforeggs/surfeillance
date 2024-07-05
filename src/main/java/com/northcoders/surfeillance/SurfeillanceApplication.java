package com.northcoders.surfeillance;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.northcoders.surfeillance.service.apis.tidalapi.TidalEventDAO;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


@SpringBootApplication
@EntityScan(basePackages = "com.northcoders.surfeillance.model")
@ComponentScan(basePackages = {"com.northcoders.surfeillance"})
public class SurfeillanceApplication {

	private final static Logger logger = LoggerFactory.getLogger(SurfeillanceApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SurfeillanceApplication.class, args);

		try {
			FileInputStream refreshToken = new FileInputStream("src/main/resources/serviceAccountKey.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(refreshToken))
					.build();

			FirebaseApp defaultApp = FirebaseApp.initializeApp(options);
			logger.info("FIREBASE INIT",defaultApp.getName());

		} catch (IOException e) {
			e.printStackTrace();

		}




	}

}
