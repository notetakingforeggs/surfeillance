package com.northcoders.surfeillance;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.northcoders.surfeillance.model.dto.ConditionsDTO;
import com.northcoders.surfeillance.repository.SpotRepository;
import com.northcoders.surfeillance.service.apis.tidalapi.TidalEventDAO;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidalEvent;
import com.northcoders.surfeillance.service.apis.tidalapi.daomodel.TidesDTO;
import com.northcoders.surfeillance.service.logic.ServiceImpl;
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
import java.util.List;


@SpringBootApplication
@EntityScan(basePackages = "com.northcoders.surfeillance.model")
@ComponentScan(basePackages = {"com.northcoders.surfeillance"})
public class SurfeillanceApplication {

	private final static Logger logger = LoggerFactory.getLogger(SurfeillanceApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SurfeillanceApplication.class, args);

		TidesDTO tides = TidalEventDAO.getTideByLocation("0265");

//		ServiceImpl service = new ServiceImpl();
//		List<ConditionsDTO> conditions = service.getConditions();
//
		System.out.println(tides);



	}

}
