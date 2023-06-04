package github.oineh.user.service.jpa;

import github.oineh.user.entity.User;
import github.oineh.user.entity.UserEntity;
import github.oineh.user.repository.jpa.JpaUserRepository;
import github.oineh.user.service.usecase.SignUpUserCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaSignUpUserCase implements SignUpUserCase {
    private final JpaUserRepository jpaUserRepository;

    public User signUp(String id, String pw) {
        jpaUserRepository.findByLoginId(id)
                .ifPresent(user -> { throw new IllegalArgumentException("회원 아이디가 존재합니다."); });

        return Optional.of(jpaUserRepository.save(new UserEntity(id,pw)))
                .orElseThrow(() ->new IllegalArgumentException("회원이 생성되지 않습니다. 다시 시도해 주시기 바랍니다."))
                .toDomain();
    }
}
