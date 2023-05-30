package github.oineh.user.local.repository;

import github.oineh.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class LocalUserRepository implements UserRepository {

    // jpa 가 db 매핑시킬때 이코드만 슬쩍 가져와서 매칭시켜주면 entity 내부필드는 final 을 선언해서 불변성을 가질수 있지 않을까?
    private final ConcurrentHashMap<Long, User> datas;

    @Override
    public Optional<User> create(User user) {
        datas.put(datas.entrySet().stream().count(), user);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> update(Long index, User user) {
        datas.remove(index);
        datas.put(index, user);
        return Optional.ofNullable(user);
    }

    @Override
    public void delete(Long index) {
        datas.remove(index);
    }

    @Override
    public Optional<User> select(Long id) {
        return Optional.ofNullable(datas.get(id));
    }

    @Override
    public Optional<Long> findById(String id) {
        return datas.entrySet().stream()
                .filter(entry -> entry.getValue().getId().equals(id))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    public Optional<User> findByIdAndPw(String id, String pw) {
        return datas.values().stream()
                .filter(user -> user.getId().equals(id))
                .filter(user -> user.getPw().equals(pw))
                .findFirst();
    }
}
