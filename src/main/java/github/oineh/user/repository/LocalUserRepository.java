package github.oineh.user.repository;

import github.oineh.user.entity.User;

import java.util.HashMap;

public class LocalUserRepository implements UserRepository{
    private final HashMap<Long, User> datas;

    public LocalUserRepository() {
        this.datas = new HashMap<>();
    }

    @Override
    public void create(User user) {
        datas.put((long) datas.size(), user);
    }

    @Override
    public boolean update(Long index, User user) {
        datas.remove(index);
        datas.put(index,user);
        return true;
    }

    @Override
    public boolean delete(Long index) {
        datas.remove(index);
        return false;
    }


    @Override
    public User select(Long id){
        return datas.get(id);
    }

    public Long select(User id){
        return datas.entrySet().stream()
                .filter(val -> val.getValue().isId(id))
                .findFirst()
                .orElseThrow()
                .getKey();
    }
}
