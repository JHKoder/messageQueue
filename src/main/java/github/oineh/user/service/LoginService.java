package github.oineh.user.service;

import github.oineh.user.entity.User;
import github.oineh.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public User login(String id,String pw){
        return userRepository.select(id,pw)
                .orElseThrow();
    }
}
