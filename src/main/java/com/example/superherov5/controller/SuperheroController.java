package com.example.superherov5.controller;

import com.example.superherov5.dto.CityHeroDTO;
import com.example.superherov5.dto.HeroPowerDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.dto.SuperheroFormDTO;
import com.example.superherov5.repositories.SuperheroRepository;
import com.example.superherov5.service.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhelte")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping(path = {"", "/"})
    public String index (Model model) {
        model.addAttribute("superheroes", superheroService.getSuperhero());
        return "index";
    }

    @GetMapping(path = {"superhelt/{superheroName}"})
    public String getOneSuperhero(@PathVariable String superheroName, Model model) {
        List<SuperheroDTO> superhero = superheroService.getOneSuperhero(superheroName);
        model.addAttribute("superpower", superhero);
        return "powers";
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

    @GetMapping(path = {"/add"})
    public String addSuperhero (Model model) {
        SuperheroFormDTO superheroFormDTO = new SuperheroFormDTO();
        model.addAttribute("CreateSuperhero", superheroFormDTO);
        model.addAttribute("city", superheroService.getCity());
        model.addAttribute("power", superheroService.getSuperpower());
        return "add";
    }

    @PostMapping(path ={"/add"})
    public String returnSuperhero (@ModelAttribute("superhero") SuperheroFormDTO superheroFormDTO) {
        superheroService.addSuperHero(superheroFormDTO);
        System.out.println(superheroFormDTO.toString());
    return "redirect:/superhelte";
    }

}
