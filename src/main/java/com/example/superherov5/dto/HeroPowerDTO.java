package com.example.superherov5.dto;

public class HeroPowerDTO {

    // En DTO til at finde ud af hvilke superkræfte en superhelt har
    private String superheroName;
    private String realName;
    private String superpower;


    public HeroPowerDTO(String superheroName, String realName, String superpower) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpower = superpower;

    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperpower() {
        return superpower;
    }

}
