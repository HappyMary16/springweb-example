package org.example.controller;

import org.example.model.Cat;
import org.example.model.CatBehaviour;
import org.example.service.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Опрацьовує HTTP запити без опрацювання помилок.
 * Завжди повертає код відповіді 200
 */
@RestController
public class SimpleCatController {

    private final CatService catService;

    public SimpleCatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/simple/cats")
    public Collection<Cat> getAllCats(@RequestParam(required = false) CatBehaviour behaviour) {
        if (behaviour != null) {
            return catService.getCatsByBehaviour(behaviour);
        }

        return catService.getAllCats();
    }

    @GetMapping("/simple/cats/{catName}")
    public Cat getCat(@PathVariable String catName) {
        return catService.getCat(catName);
    }

    @PostMapping("/simple/cats")
    public boolean createCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    @PutMapping("/simple/cats/{catName}")
    public Cat updateCat(@PathVariable String catName, @RequestBody Cat cat) {
        return catService.updateCat(catName, cat);
    }

    @DeleteMapping("/simple/cats/{catName}")
    public Cat deleteCat(@PathVariable String catName) {
        return catService.deleteCat(catName);
    }
}
