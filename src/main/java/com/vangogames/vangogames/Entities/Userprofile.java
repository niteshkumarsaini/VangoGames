package com.vangogames.vangogames.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Userprofile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id")
    private String username;
    @Size(min = 1, message = "Gender cannot be blank.")
    private String gender;
    @Size(min = 10, max = 10, message = "Please Enter valid Number")
    private String whatsapp;
    @AssertTrue(message = "Please Accept Email Notifications.")
    private boolean emailNotification;
    @AssertTrue(message = "Please Accept Whatsapp Notifications.")
    private boolean whatsappNotification;
    @AssertTrue(message = "Please Accept terms and conditions first. ")
    private boolean checkbox;

    private boolean mobileNotification;
    private String age;
    @OneToOne
    @JsonBackReference
    private User user;

    public int getId() {
        return id;
    }

    public Userprofile() {
    }

    public Userprofile(@NotBlank(message = "Name cannot be blank") String name,
            @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id") String username,
            @Size(min = 1, message = "Gender cannot be blank.") String gender,
            @Size(min = 10, max = 10, message = "Please Enter valid Number") String whatsapp,
            @AssertTrue(message = "Please Accept Email Notifications.") boolean emailNotification,
            @AssertTrue(message = "Please Accept Whatsapp Notifications.") boolean whatsappNotification,
            @AssertTrue(message = "Please Accept terms and conditions first. ") boolean checkbox,
            boolean mobileNotification, String age, User user) {
        this.name = name;
        this.username = username;
        this.gender = gender;
        this.whatsapp = whatsapp;
        this.emailNotification = emailNotification;
        this.whatsappNotification = whatsappNotification;
        this.checkbox = checkbox;
        this.mobileNotification = mobileNotification;
        this.age = age;
        this.user = user;
    }

    public Userprofile(int id, @NotBlank(message = "Name cannot be blank") String name,
            @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Enter a valid email id") String username,
            @Size(min = 1, message = "Gender cannot be blank.") String gender,
            @Size(min = 10, max = 10, message = "Please Enter valid Number") String whatsapp,
            @AssertTrue(message = "Please Accept Email Notifications.") boolean emailNotification,
            @AssertTrue(message = "Please Accept Whatsapp Notifications.") boolean whatsappNotification,
            @AssertTrue(message = "Please Accept terms and conditions first. ") boolean checkbox,
            boolean mobileNotification, String age, User user) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.gender = gender;
        this.whatsapp = whatsapp;
        this.emailNotification = emailNotification;
        this.whatsappNotification = whatsappNotification;
        this.checkbox = checkbox;
        this.mobileNotification = mobileNotification;
        this.age = age;
        this.user = user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public boolean isWhatsappNotification() {
        return whatsappNotification;
    }

    public void setWhatsappNotification(boolean whatsappNotification) {
        this.whatsappNotification = whatsappNotification;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public boolean isMobileNotification() {
        return mobileNotification;
    }

    public void setMobileNotification(boolean mobileNotification) {
        this.mobileNotification = mobileNotification;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
