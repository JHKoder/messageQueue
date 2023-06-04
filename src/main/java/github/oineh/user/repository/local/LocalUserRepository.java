package github.oineh.user.repository.local;


import github.oineh.common.Repository;
import github.oineh.user.entity.User;

import java.util.Optional;

public interface LocalUserRepository extends Repository<Long, User> {

    Optional<User> findByLoginIdAndPw(String id, String pw);

    Optional<Long> findByLoginId(String id);

    Long getId();
}
