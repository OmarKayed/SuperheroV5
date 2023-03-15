package com.example.superherov5.controller;

import com.example.superherov5.dto.CityHeroDTO;
import com.example.superherov5.dto.HeroPowerDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.model.Superhero;
import com.example.superherov5.service.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("superhelte")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroList = superheroService.getSuperhero();
        return new ResponseEntity<List<Superhero>>(superheroList, HttpStatus.OK);
    }

    @GetMapping(path = {"superhelt/{superheroName}"})
    public ResponseEntity<List<SuperheroDTO>> getOneSuperhero(@PathVariable String superheroName) {
        List<SuperheroDTO> superhero = superheroService.getOneSuperhero(superheroName);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping(path = {"/superpower/count/{superheroName}"})
    public ResponseEntity<List<HeroPowerDTO>> getAllPower(@PathVariable String superheroName) {
        List<HeroPowerDTO> superheroList = superheroService.getAllPowers(superheroName);
        return new ResponseEntity<List<HeroPowerDTO>>(superheroList, HttpStatus.OK);
    }

    @GetMapping(path = {"superpower/{superheroName}"})
    public ResponseEntity<List<HeroPowerDTO>> CertinHeroWithHeropower(@PathVariable String superheroName) {
        List <HeroPowerDTO> superheroWithPower = superheroService.CertinHeroWithHeropower(superheroName);
        return new ResponseEntity<>(superheroWithPower, HttpStatus.OK);
    }

    @GetMapping(path = {"city/{superheroName}"})
    public ResponseEntity<List<CityHeroDTO>> HeroFromCityWithName(@PathVariable String superheroName) {
        List<CityHeroDTO> superheroCitylist = superheroService.HeroFromCityWithName(superheroName);
        return new ResponseEntity<>(superheroCitylist, HttpStatus.OK);
    }

}
