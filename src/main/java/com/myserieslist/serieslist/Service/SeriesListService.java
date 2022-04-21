package com.myserieslist.serieslist.Service;

import java.util.List;
import java.util.Optional;

import com.myserieslist.serieslist.Entity.SeriesList;
import com.myserieslist.serieslist.Entity.Serie;
import com.myserieslist.serieslist.Entity.User;
import com.myserieslist.serieslist.Repository.SeriesListRepository;
import com.myserieslist.serieslist.Repository.SerieRepository;
import com.myserieslist.serieslist.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesListService {
    private final SeriesListRepository serieListRepository;
    private final UserRepository userRepository;
    private final SerieRepository serieRepository;

    @Autowired
    public SeriesListService(SeriesListRepository serieListRepository, UserRepository userRepository,
            SerieRepository serieRepository) {
        this.serieListRepository = serieListRepository;
        this.userRepository = userRepository;
        this.serieRepository = serieRepository;
    }

    public SeriesList createList(Long userId, SeriesList list) { 
        User user = userRepository.getById(userId);
        list.setuser(user);
        return serieListRepository.save(list);
    }

    public List<SeriesList> getLists() {
        List<SeriesList> lists = serieListRepository.findAll();
        return lists;
    }

    public Optional<SeriesList> listById(Long serieId) {
        return serieListRepository.findById(serieId);
    }

    public void deleteList(Long listId) {
        serieListRepository.deleteById(listId);
    }

    public SeriesList updateList(Long listId, SeriesList SerieList, Serie serie) {
        SeriesList list = serieListRepository.getById(listId);
        list.setName(SerieList.getName());
        list.addSerie(serie);
        return serieListRepository.save(list);
    }

    public void deleteSerieFromList(Long listId, Long serieId) {
        SeriesList list = serieListRepository.getById(listId);
        Serie serie = serieRepository.getById(serieId);
        list.removeSerie(serie);
        serieListRepository.save(list);
    }

    public SeriesList listByName(String name) {
        return serieListRepository.findByName(name);
    }

    public List<SeriesList> listCreatedByUser(Long user_id) {
        User user = userRepository.getById(user_id);
        return user.getListCreated();
    }
}