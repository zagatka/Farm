package myApplication.service.Impl;

import myApplication.dto.AnimalDto;
import myApplication.entity.AnimalEntity;
import myApplication.enumerations.AnimalType;
import myApplication.exception.NoElementException;
import myApplication.mapper.AnimalMapper;
import myApplication.repository.AnimalRepository;
import myApplication.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
    public void deleteAnimal(Long animalId) throws NoElementException {
        Optional<AnimalEntity> animalEntityOptional = animalRepository.findById(animalId);
        if (animalEntityOptional.isPresent()) {
            animalRepository.delete(animalEntityOptional.get());
        } else {
            throw new NoElementException("No animal with given id in database!");
        }
    }

    @Override
    public AnimalDto findAnimalById(Long id) throws NoElementException {
        Optional<AnimalEntity> animalOptional = animalRepository.findById(id);
        if (animalOptional.isPresent()) {
            AnimalEntity animalEntity = animalOptional.get();
            return AnimalMapper.mapToDto(animalEntity);
        } else {
            throw new NoElementException("No animal with given id in database!");
        }
    }

    @Override
    public List<AnimalDto> findAnimalByAnimalType(AnimalType animalType) throws NoElementException {
        List<AnimalEntity> animalEntities = animalRepository.findAll().stream()
                .filter(p -> p.getType().equals(animalType))
                .collect(Collectors.toList());
        if (animalEntities.size() == 0) {
            throw new NoElementException("Animals of given type are not found.");
        }
        return AnimalMapper.mapToDtos(animalEntities);
    }

    @Override
    public List<AnimalDto> findAllAnimals() {
        List<AnimalEntity> animalEntities = animalRepository.findAll();
        return AnimalMapper.mapToDtos(animalEntities);
    }
}
