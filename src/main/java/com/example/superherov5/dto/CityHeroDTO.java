package com.example.superherov5.dto;

public class CityHeroDTO {

    // En DTO til at kunne finde ud af hvilken by superhelten er fra

    private String realName;
    private String cityName;

    public CityHeroDTO (String realName, String cityName) {
        this.realName = realName;
        this.cityName = cityName;
    }

    public String getCityname() {
        return cityName;
    }

    public String getRealName() {
        return realName;
    }
}
