package com.kdramawiki.kdramas.Entity;

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

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String first_name;
    private String surname;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DramaList> list_created = new ArrayList<>();

    @Column(name = "email", unique = true)
    private String email;

    public User(Long id, String first_name, String surname, String email, List<DramaList> list_created) {
        this.id = id;
        this.first_name = first_name;
        this.surname = surname;
        this.email = email;
        this.list_created = list_created;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DramaList> getList_created() {
        return list_created;
    }

    public void setUser_lists(List<DramaList> list_created) {
        this.list_created = list_created;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", first_name=" + first_name + ", id=" + id + ", surname=" + surname
                + ", user_lists=" + list_created + "]";
    }

}
