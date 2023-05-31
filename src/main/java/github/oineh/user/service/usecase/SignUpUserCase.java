package github.oineh.user.service.usecase;

import github.oineh.user.entity.User;

public interface SignUpUserCase {
    User signUp(String id, String pw);
}
