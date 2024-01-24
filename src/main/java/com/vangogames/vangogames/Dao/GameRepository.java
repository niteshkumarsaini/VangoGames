package com.vangogames.vangogames.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vangogames.vangogames.Entities.Game;
import com.vangogames.vangogames.Entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("SELECT g FROM Game g WHERE g.user = :user")
    List<Game> findAllByUser(User user);

    // If you want to limit the result to a single game, you can use the first
    // result
    @Query("SELECT g FROM Game g WHERE g.user = :user")
    Optional<Game> findFirstByUser(User user);
}
