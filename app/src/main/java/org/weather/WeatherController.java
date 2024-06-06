package org.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    private final String API_KEY = "your_api_key";
    private final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = WEATHER_URL + "?q=" + city + "&appid=" + API_KEY;
        return restTemplate.getForObject(url, String.class);
    }
}
