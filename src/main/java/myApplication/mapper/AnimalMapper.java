package myApplication.mapper;

import myApplication.dto.AnimalDto;
import myApplication.entity.AnimalEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalMapper {

    public static AnimalEntity mapToEntity(AnimalDto animalDto) {
        if (animalDto == null) {
            return null;
        }

        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setAge(animalDto.getAge());
        animalEntity.setName(animalDto.getName());
        animalEntity.setType(animalDto.getType());

        return animalEntity;
    }

    public static AnimalDto mapToDto(AnimalEntity animalEntity) {
        return AnimalDto.builder()
                .withId(animalEntity.getId())
                .withType(animalEntity.getType())
                .withName(animalEntity.getName())
                .withAge(animalEntity.getAge())
                .build();
    }

    public static List<AnimalDto> mapToDtos(List<AnimalEntity> animalEntities) {
        return animalEntities.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }
}
