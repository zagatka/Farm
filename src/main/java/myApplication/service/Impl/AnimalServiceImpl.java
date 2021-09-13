package myApplication.service.Impl;

import myApplication.dto.AnimalDto;
import myApplication.entity.AnimalEntity;
import myApplication.enumerations.AnimalType;
import myApplication.exception.NoElementException;
import myApplication.mapper.AnimalMapper;
import myApplication.repository.AnimalRepository;
import myApplication.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void addAnimal(AnimalDto animalDto) {
        animalRepository.save(AnimalMapper.mapToEntity(animalDto));
    }

    @Override
    public void deleteAnimal(AnimalDto animalDto) {

    }

    @Override
    public AnimalDto findAnimalById(Long id) throws NoElementException {
        Optional<AnimalEntity> animalOptional = animalRepository.findById(id);
        if(animalOptional.isPresent()){
            AnimalEntity animalEntity = animalOptional.get();
            return AnimalMapper.mapToDto(animalEntity);
        }else{
            throw new NoElementException("No animal with given id in database!");
        }
    }

    @Override
    public List<AnimalDto> findAnimalByAnimalType(AnimalType animalType) {
        return null;
    }
}
