package com.ib.stm.controller;

/**
 * AppConfig.java
 *
 * @author Mohamed Subaideen Imran A (mohamedsubaideenimran@nmsworks.co.in)
 * @module com.ib.stm.controller
 * @created Dec 18, 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

