package github.oineh.user.jpa.repository;

import github.oineh.user.jpa.entity.UserEntity;
import github.oineh.user.local.entity.User;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserInfo {
    private final EntityManager entityManager;


    public void update(User user) {
        UserEntity entity = Optional.of(entityManager.find(UserEntity.class, user.getId()))
                .orElseThrow(() -> new PermanenceException("entity update exception"));
        if (entity != null) {
            entityManager.merge(UserEntity.of(user));
        }
    }

    public void delete(User user) {
        UserEntity entity = Optional.of(entityManager.find(UserEntity.class, user.getId()))
                .orElseThrow(() -> new PermanenceException("entity delete exception"));
        if (entity != null) {
            entityManager.remove(UserEntity.of(user));
        }
    }

    public void insert(User user) {
        Optional<UserEntity> entity = Optional.ofNullable(entityManager.find(UserEntity.class, user.getId()));
        if (entity.isEmpty()) {
            entityManager.persist(UserEntity.of(user));
        }
    }
}
