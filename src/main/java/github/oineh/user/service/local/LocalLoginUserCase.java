package github.oineh.user.service.local;

import github.oineh.user.entity.User;
import github.oineh.user.repository.local.LocalUserRepository;
import github.oineh.user.service.usecase.LoginUserCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocalLoginUserCase implements LoginUserCase {
    private final LocalUserRepository localUserRepository;

    public User login(String id, String pw) {
        return localUserRepository.findByLoginIdAndPw(id, pw)
                .orElseThrow(() -> new IllegalArgumentException("회원정보가 일치하지 않습니다."));
    }
}
