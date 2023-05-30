package github.oineh.user.local.service;

import github.oineh.user.local.entity.User;
import github.oineh.user.local.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User login(String id, String pw) {
        return userRepository.findByIdAndPw(id, pw)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 일치하지 않습니다."));
    }

    public User signUp(String id, String pw) {
        userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("이미 생성된 ID 입니다."));

        return userRepository.create(new User(id, pw))
                .orElseThrow(() -> new IllegalArgumentException("회원이 생성되지 않습니다. 다시 시도해 주시기 바랍니다."));
    }
}
