package myApplication.service.Impl;

import myApplication.dto.PlantDto;
import myApplication.enumerations.PlantType;
import myApplication.service.PlantService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlantServiceImpl implements PlantService {
    @Override
    public void addPlant(PlantDto plantDto) {

    }

    @Override
    public void deletePlant(PlantDto plantDto) {

    }

    @Override
    public PlantDto findPlantById(Long id) {
        return null;
    }

    @Override
    public List<PlantDto> findPlantsByType(PlantType plantType) {
        return null;
    }
}
