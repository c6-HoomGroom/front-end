package com.example.auth.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    @Column(name = "birth_date", nullable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate birthDate;
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public String getLastName() {
        return lastName;
    }
    public long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    public LocalDate getBirthDate() { return birthDate; }

    public void setBirthDate(LocalDate birthDate) { this.birthDate=birthDate;}

    public void setRole(String role) { this.role=role;
}

    @Column(name = "role",nullable=false, length = 20)
    private String role;

    public String getRole() { return role;}
}
