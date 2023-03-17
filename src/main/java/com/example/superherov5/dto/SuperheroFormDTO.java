package com.example.superherov5.dto;

import java.util.List;

public class SuperheroFormDTO {
    private int superheroID;
    private String superheroName;
    private String realName;
    private int creationYear;
    private String cityName;
    List<String> superpower;

    public SuperheroFormDTO(int superheroID, String superheroName, String realName, int creationYear, String cityName, List<String> superpower) {
        this.superheroID = superheroID;
        this.superheroName = superheroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.cityName = cityName;
        this.superpower = superpower;
    }

    public SuperheroFormDTO() {
    }

    public void add(String power) {
        superpower.add(power);
    }

    public int getSuperheroID() {
        return superheroID;
    }

    public void setSuperheroID(int superheroID) {
        this.superheroID = superheroID;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getSuperpower() {
        return superpower;
    }

    public void setSuperpower(List<String> superpower) {
        this.superpower = superpower;
    }

    @Override
    public String toString() {
        return "SuperheroFormDTO{" +
                "superheroID=" + superheroID +
                ", superheroName='" + superheroName + '\'' +
                ", realName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                ", cityName='" + cityName + '\'' +
                ", superpower=" + superpower +
                '}';
    }
}
