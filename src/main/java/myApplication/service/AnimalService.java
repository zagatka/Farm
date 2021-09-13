package myApplication.service;


import myApplication.dto.AnimalDto;
import myApplication.enumerations.AnimalType;
import myApplication.exception.NoElementException;

import java.util.List;

public interface AnimalService {

    void addAnimal(AnimalDto animalDto);

    void deleteAnimal(AnimalDto animalDto);

    AnimalDto findAnimalById(Long id) throws NoElementException;

    List<AnimalDto> findAnimalByAnimalType(AnimalType animalType);
}
