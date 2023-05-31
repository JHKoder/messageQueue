package github.oineh.user.service;

import github.oineh.user.repository.jpa.JpaUserRepositoryImpl;
import github.oineh.user.repository.local.LocalUserRepositoryImpl;
import github.oineh.user.service.jpa.JpaLoginUserCase;
import github.oineh.user.service.local.LocalLoginUserCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("로그인 서비스")
@ExtendWith(MockitoExtension.class)
public class LoginUserServiceTest {

    @Nested
    @DisplayName("로컬")
    class LocalTest{

        @InjectMocks
        private LocalLoginUserCase service;

        @Mock
        private LocalUserRepositoryImpl repository;

        @Test
        @DisplayName("테스트")
        void login(){
            //given

            //when

            //then
        }
    }

    @Nested
    @DisplayName("JPA")
    class JpaTest{
        @InjectMocks
        private JpaLoginUserCase service;

        @Mock
        private JpaUserRepositoryImpl repository;

        @Test
        @DisplayName("테스트")
        void login(){
            //given

            //when

            //then

        }
    }
}
