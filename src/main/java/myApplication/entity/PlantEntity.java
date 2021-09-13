package myApplication.entity;

import myApplication.enumerations.PlantType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PLANT")
public class PlantEntity extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 230L;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlantType type;

    @Column(nullable = false)
    private Long area;

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
}
