package myApplication.service;


import myApplication.dto.AnimalDto;
import myApplication.enumerations.AnimalType;
import myApplication.exception.NoElementException;

import java.util.List;

public interface AnimalService {

    void addAnimal(AnimalDto animalDto);

    void deleteAnimal(Long animalId) throws NoElementException;

    AnimalDto findAnimalById(Long id) throws NoElementException;

    List<AnimalDto> findAnimalByAnimalType(AnimalType animalType) throws NoElementException;

    List<AnimalDto> findAllAnimals();

}
