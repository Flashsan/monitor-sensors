package by.agsr.monitorsensors.repository;

import by.agsr.monitorsensors.entity.RangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangeRepository
        extends JpaRepository<RangeEntity, Long> {
}
