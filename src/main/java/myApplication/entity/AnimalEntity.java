package myApplication.entity;

import myApplication.enumerations.AnimalType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ANIMAL")
public class AnimalEntity extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 230L;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalType type;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

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
}
