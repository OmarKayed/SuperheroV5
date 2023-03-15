package com.example.superherov5.model;

public class Superhero {
    // attributes
    private int superheroID;
    private String superheroName;
    private String realName;
    private int creationYear;
    private String cityName;
    private String superpower;
    private boolean isHuman;


    // constructor
    public Superhero(int superheroID, String superheroName, String realName, int creationYear, String cityName, String superpower, boolean isHuman) {
        this.superheroID = superheroID;
        this.superheroName = superheroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.cityName = cityName;
        this.superpower = superpower;
        this.isHuman = isHuman;
    }

    public Superhero(String superheroname, String realName, int creationYear) {
        this.superheroName = superheroname;
        this.realName = realName;
        this.creationYear = creationYear;

    }

    public Superhero() {

    }

    public int getSuperheroID() {
        return superheroID;
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

    public String getCityName() {
        return cityName;
    }

    public String getSuperpower() {
        return superpower;
    }

    public boolean isHuman() {
        return isHuman;
    }

    // If superheroName is empty
    public String getHeroName() {
        if (superheroName.isEmpty()) {
            return "Intet superhelte navn fundet";
        } else {
            return superheroName;
        }

    }

    @Override
    public String toString() {
        return "Superhero{" +
                "superheroID=" + superheroID +
                ", superheroName='" + superheroName + '\'' +
                ", realName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                ", cityName='" + cityName + '\'' +
                ", superpower='" + superpower + '\'' +
                ", isHuman=" + isHuman +
                '}';
    }
}
