package com.sports.fieldsmanagementsystem.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sports.fieldsmanagementsystem.DTOs.BookingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
@Slf4j
public class WeatherService {

    private static final String OPEN_METEO_API_URL = "https://api.open-meteo.com/v1/forecast";
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public WeatherService(WebClient.Builder webClientBuilder, ObjectMapper objectMapper) {
        this.webClient = webClientBuilder.baseUrl(OPEN_METEO_API_URL).build();
        this.objectMapper = objectMapper;
    }

    public boolean isTemperatureAbove10(BookingDTO bookingDTO) {
        // Use WebClient to fetch weather data
        String weatherResponse = fetchWeatherData(bookingDTO.getLat(), bookingDTO.getLon());
        return parseTemperatureFromResponse(weatherResponse) > 10;
    }

    private double getTemperature(double lat, double lon) {
        String weatherResponse = fetchWeatherData(lat, lon);
        return parseTemperatureFromResponse(weatherResponse);
    }

    private String fetchWeatherData(double lat, double lon) {
        return webClient.get().uri(uriBuilder -> uriBuilder.queryParam("latitude", lat).queryParam("longitude", lon).build()).retrieve().bodyToMono(String.class).block();
    }

    private double parseTemperatureFromResponse(String response) {
        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            JsonNode currentWeather = jsonNode.get("current_weather");
            return currentWeather.get("temperature").asDouble();
        } catch (IOException e) {
            log.error("Error parsing weather response", e);
            throw new RuntimeException(e);
        }
    }
}
