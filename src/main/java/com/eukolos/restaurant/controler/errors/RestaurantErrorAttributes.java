package com.eukolos.restaurant.controler.errors;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


class RestaurantErrorAttributes extends DefaultErrorAttributes {
    private final String currentApiVersion;
    private final String sendReportUri;

    public RestaurantErrorAttributes(String currentApiVersion, String sendReportUri) {
        this.currentApiVersion = currentApiVersion;
        this.sendReportUri = sendReportUri;
    }

    public Map<String, Object> getErrorAttributes(final WebRequest webRequest, final boolean includeStackTrace) {
        final Map<String, Object> defaultErrorAttributes = getErrorAttributes(webRequest, false);
        final RestaurantError restaurantError = RestaurantError.fromDefaultAttributeMap(
                currentApiVersion, defaultErrorAttributes, sendReportUri
        );
        return restaurantError.toAttributeMap();
    }
}
