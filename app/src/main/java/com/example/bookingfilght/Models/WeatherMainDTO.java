package com.example.bookingfilght.Models;

import java.util.List;

public class WeatherMainDTO {

    private List<WeatherDTO> weather;
    private MainDTO main;

    public List<WeatherDTO> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDTO> weather) {
        this.weather = weather;
    }

    public MainDTO getMain() {
        return main;
    }

    public void setMain(MainDTO main) {
        this.main = main;
    }
}
