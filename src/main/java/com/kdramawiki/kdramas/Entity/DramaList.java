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

@Entity
@Table(name = "list")
public class DramaList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Kdrama> drama = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user_id;

    public DramaList(Long id, String name, List<Kdrama> drama, User user_id) {
        this.id = id;
        this.name = name;
        this.drama = drama;
        this.user_id = user_id;
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

    public User getUser_id() {
        return user_id;
    }

    public void setList_owner(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "DramaList [drama=" + drama + ", id=" + id + ", name=" + name + ", user_id=" + user_id + "]";
    }

}
