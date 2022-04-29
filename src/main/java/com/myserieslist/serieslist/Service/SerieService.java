package com.myserieslist.serieslist.Service;

import java.util.List;

import com.myserieslist.serieslist.Entity.Serie;
import com.myserieslist.serieslist.Repository.SerieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class SerieService {
    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<Serie> getSerie() {
        return serieRepository.findAll();
    }

    public Serie addSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public void deleteSerie(Long id) {
        serieRepository.deleteById(id);
    }

    public Serie updateSerie(Long serieId, Serie serie) {
        Serie drama = serieRepository.findById(serieId).get();
        drama.setName(serie.getName());
        return serieRepository.save(drama);
    }

    public Serie serieByName(String name) {
        return serieRepository.findSerieByName(name);
    }
}
