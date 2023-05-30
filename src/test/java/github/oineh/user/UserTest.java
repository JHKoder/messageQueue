package github.oineh.user;


import org.junit.jupiter.api.Test;
import github.oineh.user.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    void create() {
        assertThat(new User("id", "pw"));
    }
}
