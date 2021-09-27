package myApplication.service;

import myApplication.dto.AnimalDto;
import myApplication.enumerations.AnimalType;
import myApplication.exception.NoElementException;
import myApplication.service.Impl.AnimalServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AnimalServiceIntegrationTest {

    private static final long ANIMAL_ID = 1L;

    @Autowired
    private AnimalServiceImpl animalService;

    @Transactional
    @Test
    void shouldFindAnimalByIdFindDogKubus() throws NoElementException {
        //g
        AnimalDto animalDtoToCompare = new AnimalDto();
        animalDtoToCompare.setName("Kubus");
        animalDtoToCompare.setAge(5);
        animalDtoToCompare.setType(AnimalType.DOG);

        //w
        AnimalDto foundAnimal = animalService.findAnimalById(ANIMAL_ID);

        //t
        Assertions.assertEquals(animalDtoToCompare.getAge(), foundAnimal.getAge());
        Assertions.assertEquals(animalDtoToCompare.getName(), foundAnimal.getName());
        Assertions.assertEquals(animalDtoToCompare.getType(), foundAnimal.getType());

    }

}
