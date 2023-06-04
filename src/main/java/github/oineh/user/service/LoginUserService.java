package github.oineh.user.service;

import github.oineh.user.entity.User;
import github.oineh.user.service.jpa.JpaLoginUserCase;
import github.oineh.user.service.local.LocalLoginUserCase;
import github.oineh.user.service.usecase.LoginUserCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginUserService implements LoginUserCase {

    private final JpaLoginUserCase jpaLoginUserCase;
    private final LocalLoginUserCase loginUserCase;

    @Override
    public User login(String id, String pw) {
        //1. case jpa login success
        //2. case jpa login fail And jpa connect out
        //3. case local login

        //jpa connect success local data join ...
        //join case 1. save
        // 흠 이건 저장 레벨을 설정 해둬야 겠네
        // 1급 기존 값 없으면 추가
            // 예시 1) 회원가입 ( 최상위 연관 부모 테이블?)
        // 2급 값 추가시 여러 로직을 타는 경우
            // 예시 1) 회원이 상품을 주문함 [ 주문 -> 외부 API 결제 -> 완료]
            // 예시 2) 예약 시스템을 과 연결된 경우 [예약 -> 예약실행- > 완료 ]
            // 예시 3) 결제 와 관련된 부분
        // 3급 어떤 하위 연관관계 데이터가 추가
            // 예시 1) 어디 게시글에 댓글이 추가됨
            // 예시 2) 회원의 장바구니안에 상품이 추가됨
            // 예시 3) 회원을 그룹에 초대함

        //join case 2. update
        //join case 3. delete
        //join case 4. select? -> no select

        return null;
    }
}
