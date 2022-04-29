package com.myserieslist.serieslist.Controller;

import java.util.List;
import java.util.Optional;

import com.myserieslist.serieslist.Entity.SeriesList;
import com.myserieslist.serieslist.Entity.Serie;
import com.myserieslist.serieslist.Service.SeriesListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeriesListController {
    private final SeriesListService serieListService;

    @Autowired
    public SeriesListController(SeriesListService serieListService) {
        this.serieListService = serieListService;
    }

    @PostMapping("/user/{userId}/list/")
    public ResponseEntity<?> createNewList(@PathVariable("userId") Long userId, @RequestBody SeriesList list) {
        return new ResponseEntity<>(serieListService.createList(userId, list), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<SeriesList> getAllLists() {
        return serieListService.getLists();
    }

    @GetMapping("/list/listById") 
    public Optional<SeriesList> getListById(@RequestParam("id") Long serieId) {
        return serieListService.listById(serieId);
    }

    @DeleteMapping("/list/{listId}")
    public void deleteListById(@PathVariable("listId") Long listId) {
        serieListService.deleteList(listId);
    }

    @PutMapping("/list/{listId}/serie/{serieId}")
    public SeriesList modifyListById(@PathVariable("listId") Long listId, 
                                    @PathVariable("serieId") Serie serie, 
                                    @RequestBody SeriesList serieList) {
        return serieListService.updateList(listId, serieList, serie);
    }

    @DeleteMapping("list/{listId}/serie/{serieId}") 
    public void deleteDramaFromList(@PathVariable("listId") Long listId, 
                                    @PathVariable("serieId") Long dramaId) {
        serieListService.deleteSerieFromList(listId, dramaId);
    }

    @GetMapping("/list/{name}")
    public SeriesList getListByName(@RequestParam("name") String name) {
        return serieListService.listByName(name);
    }

    @GetMapping("/user/{userId}/list")
    public List<SeriesList> getListCreatedByUser(@PathVariable("userId") Long userId) {
        return serieListService.listCreatedByUser(userId);
    }
}