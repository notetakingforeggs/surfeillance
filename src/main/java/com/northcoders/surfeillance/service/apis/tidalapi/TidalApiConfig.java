package com.northcoders.surfeillance.service.apis.tidalapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TidalApiConfig {

    Properties properties;

    public TidalApiConfig() {
        properties = new Properties();

        String configFilePath = "src/main/resources//application.properties";
        File ConfigFile = new File(configFilePath);
        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);

            properties.load(configFileReader);
            configFileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getTidalEventBaseUrl() {
        return properties.getProperty("base.tidal.url");
    }
    public String getHeaderKey() {
        return properties.getProperty("header.key");
    }

    public String getHeaderVal() {
        return properties.getProperty("header.value");
    }


}
