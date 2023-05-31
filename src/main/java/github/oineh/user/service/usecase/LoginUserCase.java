package github.oineh.user.service.usecase;

import github.oineh.user.entity.User;

public interface LoginUserCase {
    User login(String id, String pw);
}
