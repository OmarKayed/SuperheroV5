package com.example.superherov5.repositories;

import com.example.superherov5.dto.CityHeroDTO;
import com.example.superherov5.dto.HeroPowerDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.dto.SuperheroFormDTO;
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


    public List<String> getCity (){
        List<String> getCityList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT cityName FROM city";
            PreparedStatement stmt = con.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String cityName = rs.getString("cityName");
                getCityList.add(cityName);
            }
          return getCityList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<String> getSuperpower() {
            List<String> getSuperpowerList = new ArrayList<>();
            try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
                String SQL = "SELECT Powername FROM superPower";
                PreparedStatement stmt = con.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String Powername = rs.getString("Powername");
                    getSuperpowerList.add(Powername);
                }
                return getSuperpowerList;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    public void addSuperHero(SuperheroFormDTO form) {
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            // ID's
            int cityId = 0;
            int heroId = 0;
            List<Integer> powerIDs = new ArrayList<>();

            // find city_id
            String SQL1 = "select cityID from city where cityName = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL1);
            pstmt.setString(1, form.getCityName());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cityId = rs.getInt("cityID");
            }

            // insert row in superhero table
            String SQL2 = "insert into superhero (superheroName, realName, creationYear, cityName) " +
                    "values(?, ?, ?, ?);";
            pstmt = con.prepareStatement(SQL2, Statement.RETURN_GENERATED_KEYS); // return autoincremented key
            pstmt.setString(1, form.getSuperheroName());
            pstmt.setString(2, form.getRealName());
            pstmt.setInt(3, form.getCreationYear());
            pstmt.setInt(4, cityId);
            int rows = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                heroId = rs.getInt(1);
            }


            // find power_ids
            String SQL3 = "select superPowerID from superpower where Powername = ?;";
            pstmt = con.prepareStatement(SQL3);

            for (String power : form.getSuperpower()) {
                pstmt.setString(1, power);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    powerIDs.add(rs.getInt("superpowerID"));
                }
            }

            // insert entries in superhero_powers join table
            String SQL4 = "insert into superheroPower (heroID, superpowerID) values (?,?);";
            pstmt = con.prepareStatement(SQL4);

            for (int i = 0; i < powerIDs.size(); i++) {
                pstmt.setInt(1, heroId);
                pstmt.setInt(2, powerIDs.get(i));
                rows = pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

