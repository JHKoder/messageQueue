package github.oineh.user.jpa.repository;

import github.oineh.user.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<Long, UserEntity> {
    Optional<UserEntity> findById(String id);
}
