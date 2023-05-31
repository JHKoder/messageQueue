package github.oineh.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;


@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String pw;

    public UserEntity(String loginId, String pw) {
        this.loginId = loginId;
        this.pw = pw;
    }

    public static UserEntity of(User user) {
        return new UserEntity(user.getLoginId(), user.getPw());
    }

    public User toDomain() {
        return new User(this.id,this.loginId, this.pw);
    }
}
