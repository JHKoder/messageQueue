package github.oineh.user.repository.local;

import github.oineh.user.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class LocalUserRepositoryImpl implements LocalUserRepository {

    // db 연결이 끊기면 긴급용으로 사용하면 좋지 않을까?
    private final ConcurrentHashMap<Long, User> datas;

    @Override
    public Optional<User> save(User user) {
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
    public Optional<Long> findByLoginId(String id) {
        return datas.entrySet().stream()
                .filter(entry -> entry.getValue().getLoginId().equals(id))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    public Optional<User> findByLoginIdAndPw(String id, String pw) {
        return datas.values().stream()
                .filter(user -> user.getLoginId().equals(id))
                .filter(user -> user.getPw().equals(pw))
                .findFirst();
    }

    @Override
    public Long getId() {
        return datas.entrySet().stream().count();
    }
}
