package github.oineh.user.service;

import github.oineh.user.entity.User;
import github.oineh.user.repository.UserRepository;

public class SignService {
    private final UserRepository repository;

    public SignService(UserRepository repository) {
        this.repository = repository;
    }

    public Long isSelectId(String id){
        return repository.findById(id).orElseThrow();
    }

    public void signUp(String id,String pw){
        repository.findById(id).orElseThrow();
        repository.create(new User(id,pw));
    }
}
