package github.oineh.user.jpa.service;

import github.oineh.user.jpa.entity.UserEntity;
import github.oineh.user.jpa.repository.JpaUserInfo;
import github.oineh.user.jpa.repository.JpaUserRepository;
import github.oineh.user.local.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaUserService {

    private final JpaUserInfo jpaUserInfo;
    private final JpaUserRepository jpaUserRepository;

    public User login(String id, String pw) {
        UserEntity entity = jpaUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 일치하지 않습니다."));
        return entity.toDomain();
    }

    public User signUp(String id, String pw) {
        if (jpaUserRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("회원 아이디가 존재합니다.");
        }
        User user = new User(id, pw);
        jpaUserInfo.insert(user);
        return user;
    }
}
