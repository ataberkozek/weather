package com.weather.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class CurrentWeatherController {

    private final StubWeatherService stubWeatherService;
    private final LiveWeatherService liveWeatherService;

    public CurrentWeatherController(StubWeatherService stubWeatherService, LiveWeatherService liveWeatherService) {
        this.stubWeatherService = stubWeatherService;
        this.liveWeatherService = liveWeatherService;
    }

    @RequestMapping(value ="/current-weather", method = RequestMethod.GET)
    public String getCurrentWeather(Model model, @RequestParam(value = "city", required = false, defaultValue = "istanbul") String city, @RequestParam(value = "country", required = false, defaultValue = "tr") String country) {
        if (true) {
            model.addAttribute("currentWeather", liveWeatherService.getCurrentWeather(city ,country));
        } else {
            model.addAttribute("currentWeather", stubWeatherService.getCurrentWeather("Detroit","us"));
        }
        return "current-weather";
    }
}