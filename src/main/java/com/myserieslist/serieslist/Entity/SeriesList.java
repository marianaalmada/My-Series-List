package com.myserieslist.serieslist.Entity;

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
public class SeriesList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Serie> serie = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public SeriesList(Long id, String name, List<Serie> serie, User user) {
        this.id = id;
        this.name = name;
        this.serie = serie;
        this.user = user;
    }

    public SeriesList() {
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

    public List<Serie> getSerie() {
        return serie;
    }

    public void setserie(List<Serie> serie) {
        this.serie = serie;
    }

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public void addSerie(Serie serieObj) {
        serie.add(serieObj);
    }

    public void removeSerie(Serie serieObj) {
        serie.remove(serieObj);
    }

    @Override
    public String toString() {
        return "serieList [serie=" + serie + ", id=" + id + ", name=" + name + ", user=" + user + "]";
    }

}
