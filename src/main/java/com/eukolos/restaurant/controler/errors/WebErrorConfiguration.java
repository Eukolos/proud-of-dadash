package com.eukolos.restaurant.controler.errors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebErrorConfiguration {
    @Value("${restaurant.api.version}")
    private String currentApiVersion;
    @Value("${restaurant.sendreport.uri}")
    private String sendReportUri;

    @Bean
    public ErrorAttributes errorAttributes() {
        return new RestaurantErrorAttributes(currentApiVersion, sendReportUri);
    }
}
