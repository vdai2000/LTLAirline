package com.example.bookingfilght.Models;

public class WeatherDTO {

    String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    public WeatherDTO(String main, String description) {
        this.main = main;
        this.description = description;
    }

}
