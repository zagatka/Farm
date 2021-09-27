package myApplication.rest;

import myApplication.dto.AnimalDto;
import myApplication.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalRestController {

    private AnimalService animalService;

    @Autowired
    public AnimalRestController(AnimalService animalService){
        this.animalService = animalService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping("/animals")
    public ResponseEntity<List<AnimalDto>> findAllAnimals(){
        final List<AnimalDto> allAnimals = animalService.findAllAnimals();
        return ResponseEntity.ok().body(allAnimals);
    }

}
