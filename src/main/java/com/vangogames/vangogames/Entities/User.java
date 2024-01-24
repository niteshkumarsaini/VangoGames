package com.vangogames.vangogames.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id")
    private String username;

    @Size(min = 8, message = "Password cannot be less than 8 characters")
    private String password;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Userprofile userprofile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Game> gamesList = new ArrayList();

    public User(int id,
            @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id") String username,
            @Size(min = 8, message = "Password cannot be less than 8 characters") String password,
            @NotBlank(message = "Name cannot be blank") String name, String role, Userprofile userprofile,
            List<Game> gamesList, boolean profile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.userprofile = userprofile;
        this.gamesList = gamesList;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", role="
                + role + ", userprofile=" + userprofile + ", profile=" + profile + "]";
    }

    public User() {
    }

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean profile;

    public int getId() {
        return id;
    }

    public User(
            @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id") String username,
            @Size(min = 8, message = "Password cannot be less than 8 characters") String password,
            @NotBlank(message = "Name cannot be blank") String name, String role, Userprofile userprofile,
            boolean profile) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.userprofile = userprofile;
        this.profile = profile;
    }

    public User(int id,
            @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id") String username,
            @Size(min = 8, message = "Password cannot be less than 8 characters") String password,
            @NotBlank(message = "Name cannot be blank") String name, String role, Userprofile userprofile,
            boolean profile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.userprofile = userprofile;
        this.profile = profile;
    }

    public User(int id,
            @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id") String username,
            @NotBlank(message = "Name cannot be blank") String name, String role, Userprofile userprofile,
            boolean profile) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.role = role;
        this.userprofile = userprofile;
        this.profile = profile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Userprofile getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(Userprofile userprofile) {
        this.userprofile = userprofile;
    }

    public boolean isProfile() {
        return profile;
    }

    public void setProfile(boolean profile) {
        this.profile = profile;
    }

    public List<Game> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Game> gamesList) {
        this.gamesList = gamesList;
    }

}
