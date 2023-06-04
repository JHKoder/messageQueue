package github.oineh.user.service.local;

import github.oineh.user.entity.User;
import github.oineh.user.repository.local.LocalUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocalSignUpUserCase {
    private final LocalUserRepository localUserRepository;

    public User signUp(String id, String pw) {
        localUserRepository.findByLoginId(id)
                .orElseThrow(() -> new IllegalArgumentException("회원 아이디가 존재합니다."));

        return localUserRepository.save(new User(localUserRepository.getId()+1,id, pw))
                .orElseThrow(() -> new IllegalArgumentException("회원이 생성되지 않습니다. 다시 시도해 주시기 바랍니다."));
    }
}
