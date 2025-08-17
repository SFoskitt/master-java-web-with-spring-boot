package net.stephanietech.module_8_rest_api.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {

    private Integer userId;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate birthDate;

    public User(Integer userId, String name, LocalDate birthDate) {
        this.userId = userId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
