package by.agsr.monitorsensors.repository;

import by.agsr.monitorsensors.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository
        extends JpaRepository<SensorEntity, Long> {

    List<SensorEntity> findByNameContainingIgnoreCaseAndModelContainingIgnoreCase(String name, String model);
}
