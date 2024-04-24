package by.agsr.monitorsensors.repository;

import by.agsr.monitorsensors.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(UUID uuid);

    Optional<UserEntity> findByUsername(String username);

//    Boolean<UserEntity> existByUsername(String username);

}
