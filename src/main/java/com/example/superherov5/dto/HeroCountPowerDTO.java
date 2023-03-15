package com.example.superherov5.dto;

public class HeroCountPowerDTO {

    //En DTO til at finde ud af hvor mange kræfter en superhelt har
    private String superheroName;
    private String heroName;
    private int powerCount;

    public HeroCountPowerDTO(String superheroName, String heroName, int powerCount) {
        this.superheroName = superheroName;
        this.heroName = heroName;
        this.powerCount = powerCount;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getPowerCount() {
        return powerCount;
    }
}
