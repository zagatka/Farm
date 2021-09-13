package myApplication.service;

import myApplication.dto.PlantDto;
import myApplication.enumerations.PlantType;

import java.util.List;

public interface PlantService {
    void addPlant(PlantDto plantDto);

    void deletePlant(PlantDto plantDto);

    PlantDto findPlantById(Long id);

    List<PlantDto> findPlantsByType(PlantType plantType);
}
