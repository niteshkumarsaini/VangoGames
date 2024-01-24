package com.vangogames.vangogames.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.vangogames.vangogames.Entities.User;

@Component
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsernameAndPassword(String username, String password);

    public User findByUsername(String username);
}
