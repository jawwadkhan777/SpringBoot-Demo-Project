package io.aiven.spring.mysql.demo.repository;

import io.aiven.spring.mysql.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
}
