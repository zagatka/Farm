package myApplication.service;

import myApplication.dto.AnimalDto;
import myApplication.entity.AnimalEntity;
import myApplication.repository.AnimalRepository;
import myApplication.service.Impl.AnimalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

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
}
