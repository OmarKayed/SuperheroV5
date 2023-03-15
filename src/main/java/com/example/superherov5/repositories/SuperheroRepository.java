package com.example.superherov5.repositories;

import com.example.superherov5.dto.CityHeroDTO;
import com.example.superherov5.dto.HeroPowerDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository implements iRepository {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;


    // Return all heroes
    @Override
    public List<Superhero> getSuperhero() {
        List<Superhero> superheroes = new ArrayList<Superhero>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT * FROM Superhero;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int superheroID = rs.getInt("superheroID");
                String superheroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                String cityName = rs.getString("cityName");
                String superpower = rs.getString("superpower");
                boolean isHuman = rs.getBoolean("isHuman");
                superheroes.add(new Superhero(superheroID, superheroName, realName, creationYear, cityName, superpower, isHuman));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Return one hero
    @Override
    public List<SuperheroDTO> getOneSuperhero(String superheroName) {
        List<SuperheroDTO> superheroDTOList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superheroName, realName, creationYear, superpower FROM Superhero WHERE superheroName = ?;";
            PreparedStatement pstm = con.prepareStatement(SQL);
            pstm.setString(1, superheroName);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String superheroname = rs.getString("superheroname");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                String superpower = rs.getString("superpower");
                superheroDTOList.add(new SuperheroDTO(superheroname, realName, creationYear, superpower));
            }
            return superheroDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Get powers for one
    @Override
    public List<HeroPowerDTO> getAllPowers(String superheroName) {
        List<HeroPowerDTO> heroPowerDTOlist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superheroName, realName, count(superpower) as superpower FROM Superhero WHERE superheroName = ? GROUP BY superheroName, realName;";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, superheroName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String superheroname = rs.getString("superheroName");
                String realName = rs.getString("realName");
                String superpower = rs.getString("superpower");
                heroPowerDTOlist.add(new HeroPowerDTO(superheroname, realName, superpower));
            }
            return heroPowerDTOlist;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Get a certin hero with a certin superpower
    @Override
    public List<HeroPowerDTO> CertinHeroWithHeropower (String superheroName) {
        List<HeroPowerDTO> heroPowerDTOList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superheroName, realName, superpower FROM Superhero WHERE superheroName = ?";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, superheroName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String superheroname = rs.getString("superheroName");
                String realName = rs.getString("realName");
                String superpower = rs.getString("superpower");
                heroPowerDTOList.add(new HeroPowerDTO(superheroname, realName, superpower));
            }
            return heroPowerDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Get superhero from a city
    @Override
    public List<CityHeroDTO> HeroFromCityWithName(String superheroName){
        List<CityHeroDTO> cityHeroDTOList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT realName, cityName FROM Superhero WHERE superheroName = ?";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, superheroName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String realName = rs.getString("realName");
                String cityName = rs.getString("cityName");
                cityHeroDTOList.add(new CityHeroDTO(realName, cityName));
            }
            return cityHeroDTOList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
