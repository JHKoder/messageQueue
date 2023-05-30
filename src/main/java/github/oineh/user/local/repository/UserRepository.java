package github.oineh.user.local.repository;


import github.oineh.common.Repository;
import github.oineh.user.entity.User;

import java.util.Optional;

public interface UserRepository extends Repository<Long, User> {

    Optional<User> findByIdAndPw(String id, String pw);

    Optional<Long> findById(String id);
}
