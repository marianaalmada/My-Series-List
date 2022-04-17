package com.kdramawiki.kdramas.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "list")
public class DramaList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Kdrama> drama = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public DramaList(Long id, String name, List<Kdrama> drama, User user) {
        this.id = id;
        this.name = name;
        this.drama = drama;
        this.user = user;
    }

    public DramaList() {
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

    public List<Kdrama> getDrama() {
        return drama;
    }

    public void setDrama(List<Kdrama> drama) {
        this.drama = drama;
    }

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public void addDrama(Kdrama kdrama) {
        drama.add(kdrama);
    }

    public void removeDrama(Kdrama kdrama) {
        drama.remove(kdrama);
    }

    @Override
    public String toString() {
        return "DramaList [drama=" + drama + ", id=" + id + ", name=" + name + ", user=" + user + "]";
    }

}
