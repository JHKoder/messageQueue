package github.oineh.user;

import github.oineh.user.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    void create(){
        assertThat(new User("id","pw"));
    }
}
