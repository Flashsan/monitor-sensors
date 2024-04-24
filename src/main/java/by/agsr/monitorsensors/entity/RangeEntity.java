package by.agsr.monitorsensors.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Working range of sensor.
 *
 * @author Aliaksandr Hryharovich
 * @version 1.0.0
 * @date 18/04/2024
 */

@Getter
@Setter
@Entity
@Table(name = "range")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RangeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "from")
    private double from;

    @Column(name = "to")
    private double to;

    @OneToOne(mappedBy = "range")
    private SensorEntity sensor;
}
