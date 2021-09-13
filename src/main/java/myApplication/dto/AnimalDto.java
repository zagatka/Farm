package myApplication.dto;

import myApplication.enumerations.AnimalType;

import java.util.Objects;

public class AnimalDto {

    private Long id;
    private AnimalType type;
    private String name;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return Objects.equals(id, animalDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static AnimalDtoBuilder builder(){
        return new AnimalDtoBuilder();
    }

    public static final class AnimalDtoBuilder{

        private Long id;
        private AnimalType type;
        private String name;
        private int age;

        private AnimalDtoBuilder(){
        }

        public AnimalDtoBuilder withId(Long id){
            this.id = id;
            return this;
        }

        public AnimalDtoBuilder withType(AnimalType animalType){
            this.type = animalType;
            return this;
        }

        public AnimalDtoBuilder withName(String name){
            this.name = name;
            return this;
        }

        public AnimalDtoBuilder withAge(int age){
            this.age = age;
            return this;
        }

        public AnimalDto build(){
            AnimalDto animalDto = new AnimalDto();
            animalDto.setId(id);
            animalDto.setType(type);
            animalDto.setAge(age);
            animalDto.setName(name);
            return animalDto;
        }

    }
}
