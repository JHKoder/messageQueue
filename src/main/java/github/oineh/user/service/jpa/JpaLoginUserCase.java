package github.oineh.user.service.jpa;

import github.oineh.user.entity.User;
import github.oineh.user.repository.jpa.JpaUserRepository;
import github.oineh.user.service.usecase.LoginUserCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaLoginUserCase implements LoginUserCase {
    private final JpaUserRepository jpaUserRepository;

    public User login(String id, String pw) {
        return jpaUserRepository.findByLoginId(id)
                .filter(user -> user.getPw().equals(pw))
                .orElseThrow(() -> new IllegalArgumentException("회원정보가 일치하지 않습니다."))
                .toDomain();
    }
}
