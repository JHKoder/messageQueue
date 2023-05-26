package github.oineh.user.repository;

import github.oineh.common.Repository;
import github.oineh.user.entity.User;

import java.util.Optional;
import java.util.OptionalLong;

public interface UserRepository extends Repository<Long,User> {
    Optional<User> select(String id, String pw);
    Optional<Long> findById(String id);
}
