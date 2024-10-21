package io.aiven.spring.mysql.demo.sevice;

import io.aiven.spring.mysql.demo.model.User;
import io.aiven.spring.mysql.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo repo;

    // constructor injection
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User addNewProduct(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        repo.save(user);

        return user;
    }

    public Iterable<User> getAllUser() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }
}
