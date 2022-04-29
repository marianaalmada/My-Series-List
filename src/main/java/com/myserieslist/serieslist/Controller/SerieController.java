package com.myserieslist.serieslist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.myserieslist.serieslist.Entity.Serie;
import com.myserieslist.serieslist.Service.SerieService;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {
    private final SerieService serieService; 
    
    @Autowired 
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public List<Serie> getSerie() {
        return serieService.getSerie(); 
    }

    @PostMapping
    public ResponseEntity<?> addSerie(@RequestBody Serie serie) {
        return new ResponseEntity<>(serieService.addSerie(serie), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{serieId}")
    public void deleteSerie(@PathVariable("serieId") Long id) {
        serieService.deleteSerie(id);
    }
    
    @PutMapping(path = "/{serieId}")
    public Serie updateSerie(@PathVariable("serieId") Long serieId, @RequestBody Serie serie) {
        return serieService.updateSerie(serieId, serie);
    } 

    @GetMapping(path= "/serieByName")
    public Serie getSerieByName(@RequestParam("name") String name) {
        return serieService.serieByName(name);
    }
}
