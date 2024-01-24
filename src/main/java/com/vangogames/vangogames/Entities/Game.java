package com.vangogames.vangogames.Entities;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int game_id;
    private int score;

    public int getId() {
        return id;
    }

    public Game() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game(int id, int game_id, int score, User user) {
        this.id = id;
        this.game_id = game_id;
        this.score = score;
        this.user = user;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JsonBackReference
    private User user;

}
