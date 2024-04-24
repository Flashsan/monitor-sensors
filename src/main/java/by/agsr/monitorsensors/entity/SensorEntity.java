package by.agsr.monitorsensors.entity;

import by.agsr.monitorsensors.entity.enums.LocationEnum;
import by.agsr.monitorsensors.entity.enums.TypeEnum;
import by.agsr.monitorsensors.entity.enums.UnitEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Sensor description.
 *
 * @author Aliaksandr Hryharovich
 * @version 1.0.0
 * @date 18/04/2024
 */

@Getter
@Setter
@Entity
@Table(name = "sensors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "range", referencedColumnName = "id")
    private RangeEntity range;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private UnitEnum unit;

    @Column(name = "location")
    @Enumerated(EnumType.STRING)
    private LocationEnum location;

    @Column(name = "description")
    private String description;
}
