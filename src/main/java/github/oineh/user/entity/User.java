package github.oineh.user.entity;

import lombok.Getter;

@Getter
public class User {
    private final Long id;
    private final String loginId;
    private final String pw;

    public User(Long id,String loginId, String pw) {
        this.id = id;
        this.loginId = loginId;
        this.pw = pw;
    }
}
