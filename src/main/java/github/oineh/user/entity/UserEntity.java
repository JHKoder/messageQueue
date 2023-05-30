package github.oineh.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table
@NoArgsConstructor(access = PROTECTED)
public class UserEntity {

    @Id
    private String id;
    private String pw;

    public UserEntity(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public static UserEntity of(User user) {
        return new UserEntity(user.getId(), user.getPw());
    }

    public User toDomain() {
        return new User(this.id, this.pw);
    }
}
