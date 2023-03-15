package com.example.superherov5.dto;

public class SuperheroDTO {

    // En DTO til at finde ud af hvornår en superhelt blev født


    private String superheroName;
    private String realName;
    private int creationYear;

    public SuperheroDTO(String superheroName, String realName, int creationYear) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.creationYear = creationYear;
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
}
