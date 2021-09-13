package myApplication.dto;

import myApplication.enumerations.PlantType;

import java.util.Objects;

public class PlantDto {

    private Long id;
    private PlantType type;
    private Long area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantDto plantDto = (PlantDto) o;
        return id.equals(plantDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static PlantDtoBuilder builder() {
        return new PlantDtoBuilder();
    }

    private static final class PlantDtoBuilder {

        private Long id;
        private PlantType type;
        private Long area;

        private PlantDtoBuilder() {
        }

        public PlantDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PlantDtoBuilder withType(PlantType type) {
            this.type = type;
            return this;
        }

        public PlantDtoBuilder withArea(Long area) {
            this.area = area;
            return this;
        }

        public PlantDto biuld() {
            PlantDto plantDto = new PlantDto();
            plantDto.setId(id);
            plantDto.setType(type);
            plantDto.setArea(area);
            return plantDto;
        }
    }
}
