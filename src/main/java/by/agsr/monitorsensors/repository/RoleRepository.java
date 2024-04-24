package by.agsr.monitorsensors.repository;

import by.agsr.monitorsensors.entity.RoleEntity;
import by.agsr.monitorsensors.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(RoleEnum roleEnum);
}
