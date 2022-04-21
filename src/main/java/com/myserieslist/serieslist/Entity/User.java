package com.myserieslist.serieslist.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String surname;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SeriesList> listCreated = new ArrayList<>();

    @Column(unique = true)
    private String email;

    public User(Long id, String name, String surname, String password, List<SeriesList> listCreated,
            String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.listCreated = listCreated;
        this.email = email;
    }    

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SeriesList> getListCreated() {
        return listCreated;
    }

    public void setListCreated(List<SeriesList> listCreated) {
        this.listCreated = listCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", id=" + id + ", listCreated=" + listCreated + ", name=" + name + ", password="
                + password + ", surname=" + surname + "]";
    }
    
}
