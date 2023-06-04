package github.oineh.user.repository.jpa;

import github.oineh.exception.PermanenceException;
import github.oineh.user.entity.UserEntity;
import github.oineh.user.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserRepositoryImpl {
    private final EntityManager entityManager;

    public void update(User user) {
        entityManager.isOpen();
        UserEntity entity = Optional.of(entityManager.find(UserEntity.class, user.getLoginId()))
                .orElseThrow(() -> new PermanenceException("entity update exception"));
        if (entity != null) {
            entityManager.merge(UserEntity.of(user));
        }
    }

    public void delete(User user) {
        UserEntity entity = Optional.of(entityManager.find(UserEntity.class, user.getLoginId()))
                .orElseThrow(() -> new PermanenceException("entity delete exception"));
        if (entity != null) {
            entityManager.remove(UserEntity.of(user));
        }
    }

    public void insert(User user) {
        Optional<UserEntity> entity = Optional.ofNullable(entityManager.find(UserEntity.class, user.getLoginId()));
        if (entity.isEmpty()) {
            entityManager.persist(UserEntity.of(user));
        }
    }
}
