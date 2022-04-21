package com.myserieslist.serieslist.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity 
@Table(name = "serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Es buena práctica
    private Long id;

    @Column(nullable = false) 
    private String name;

    private LocalDate date;

    @Column(name = "description",
            columnDefinition = "TEXT") 
    private String description;

    private String genre;
    private float rating;

    @JsonIgnore
    @ManyToMany(mappedBy = "serie")
    private List<SeriesList> list = new ArrayList<>();

    public Serie(Long id, String name, LocalDate date, String description, String genre, float rating, List<SeriesList> list) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.list = list;
    }

    public Serie() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<SeriesList> getList() {
        return list;
    }

    public void setList(List<SeriesList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Serie [date=" + date + ", description=" + description + ", genre=" + genre + ", id=" + id + ", list="
                + list + ", name=" + name + ", rating=" + rating + "]";
    }

}
