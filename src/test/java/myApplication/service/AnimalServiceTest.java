package myApplication.service;

import myApplication.dto.AnimalDto;
import myApplication.entity.AnimalEntity;
import myApplication.exception.NoElementException;
import myApplication.repository.AnimalRepository;
import myApplication.service.Impl.AnimalServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    private static final long ANIMAL_ID_NOT_IN_DATABASE = 123L;
    private static final long ANIMAL_ID = 1L;

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalServiceImpl animalService;

    @Test
    void shouldAddAnimal() {
        //g
        AnimalDto animalDto = new AnimalDto();

        //w
        animalService.addAnimal(animalDto);

        //t
        Mockito.verify(animalRepository).save(Mockito.any());
    }

    @Test
    void shouldDeleteAnimalThrowExceptionForNoAnimalWithGivenIdInDatabase() {
        //g

        //w

        //t
        Assertions.assertThrows(NoElementException.class, () -> animalService.deleteAnimal(ANIMAL_ID_NOT_IN_DATABASE));
    }

    @Test
    void shouldDeleteAnimal() throws NoElementException {
        //g
        AnimalEntity animalEntity = new AnimalEntity();
        Optional<AnimalEntity> animalEntityOptional =  Optional.of(animalEntity);
        Mockito.when(animalRepository.findById(Mockito.any())).thenReturn(animalEntityOptional);

        //w
        animalService.deleteAnimal(ANIMAL_ID);

        //t
        Mockito.verify(animalRepository).delete(Mockito.any());

    }

    @Test
    void shouldFindAnimalById() throws NoElementException {
        //g


        //w
        animalService.findAnimalById(ANIMAL_ID);

        //t
        Mockito.verify(animalRepository).findById(Mockito.any());

    }

}
