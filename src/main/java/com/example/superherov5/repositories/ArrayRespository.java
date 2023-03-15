package com.example.superherov5.repositories;

import com.example.superherov5.dto.CityHeroDTO;
import com.example.superherov5.dto.HeroPowerDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.model.Superhero;

import java.util.ArrayList;
import java.util.List;

public class ArrayRespository implements iRepository {
    @Override
    public List<Superhero> getSuperhero() {
        List<Superhero> superhelt = new ArrayList<>();

        for (Superhero superhero : superhelt) {
            superhelt.add(new Superhero(superhero.getSuperheroID(), superhero.getSuperheroName(), superhero.getRealName(),
                    superhero.getCreationYear(), superhero.getCityName(), superhero.getSuperpower(), superhero.isHuman()));
        }
        return superhelt;
    }

    @Override
    public List<SuperheroDTO> getOneSuperhero(String superheroName) {
        List<SuperheroDTO> superheroDTOArrayList = new ArrayList<>();

        for (SuperheroDTO superhero : superheroDTOArrayList) {
            String name = superhero.getSuperheroName().toLowerCase();
            if (name.contains(superheroName.toLowerCase())) {
                superheroDTOArrayList.add(new SuperheroDTO(superhero.getSuperheroName(), superhero.getRealName(), superhero.getCreationYear(), superhero.getSuperpower()));
            }
        }
        return superheroDTOArrayList;
    }

    @Override
    public List<HeroPowerDTO> getAllPowers(String superheroName) {
        List<HeroPowerDTO> heroPowerDTOList = new ArrayList<>();

        for (HeroPowerDTO superpower : heroPowerDTOList) {
            if (superpower.getSuperheroName().equals(superheroName)) {
                heroPowerDTOList.add(superpower);
            }
        }
        return heroPowerDTOList;
    }

    @Override
    public List<HeroPowerDTO> CertinHeroWithHeropower(String superheroName) {
        List<HeroPowerDTO> heroPowerDTOList = new ArrayList<>();

        for (HeroPowerDTO superpower : heroPowerDTOList) {
            if (superpower.getSuperheroName().equals(superheroName)) {
                heroPowerDTOList.add(superpower);
            }
        }
        return heroPowerDTOList;

    }

    @Override
    public List<CityHeroDTO> HeroFromCityWithName(String superheroName) {
        List<CityHeroDTO> cityHeroDTOList = new ArrayList<>();

        for (CityHeroDTO cityHeroDTO : cityHeroDTOList) {
            if (cityHeroDTO.getRealName().equals(superheroName)) {
                cityHeroDTOList.add(new CityHeroDTO(cityHeroDTO.getRealName(), cityHeroDTO.getCityname()));
            }
        }

        return cityHeroDTOList;

    }


}

