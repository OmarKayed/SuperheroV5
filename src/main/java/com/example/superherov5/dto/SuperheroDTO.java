package com.example.superherov5.dto;

public class SuperheroDTO {

    // En DTO til at finde ud af hvornår en superhelt blev født


    private String superheroName;
    private String realName;
    private int creationYear;
    private String superpower;

    public SuperheroDTO(String superheroName, String realName, int creationYear, String superpower) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.superpower = superpower;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }
}
