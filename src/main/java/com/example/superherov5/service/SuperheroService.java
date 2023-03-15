package com.example.superherov5.service;

import com.example.superherov5.dto.CityHeroDTO;
import com.example.superherov5.dto.HeroPowerDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.model.Superhero;
import com.example.superherov5.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private SuperheroRepository superheroRepository;

    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<Superhero> getSuperhero() {
        return superheroRepository.getSuperhero();
    }

    public List<HeroPowerDTO> getAllPowers(String superheroName){
        return superheroRepository.getAllPowers(superheroName);
    }

    public List<SuperheroDTO> getOneSuperhero(String superheroName){
        return superheroRepository.getOneSuperhero(superheroName);
    }

    public List<HeroPowerDTO> CertinHeroWithHeropower(String superheroName) {
        return superheroRepository.CertinHeroWithHeropower(superheroName);
    }

    public List <CityHeroDTO> HeroFromCityWithName (String superheroName) {
        return superheroRepository.HeroFromCityWithName(superheroName);
    }

}
