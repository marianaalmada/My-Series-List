package com.kdramawiki.kdramas.Controller;

import java.util.List;
import java.util.Optional;

import com.kdramawiki.kdramas.Entity.DramaList;
import com.kdramawiki.kdramas.Entity.Kdrama;
import com.kdramawiki.kdramas.Service.DramaListService;

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

@RestController
@RequestMapping(value = "/list")
public class DramaListController {
    private final DramaListService dramaListService;

    @Autowired
    public DramaListController(DramaListService dramaListService) {
        this.dramaListService = dramaListService;
    }

    // Crear una lista
    @PostMapping
    public ResponseEntity<?> createNewList(@RequestBody DramaList list) {
        return new ResponseEntity<>(dramaListService.createList(list), HttpStatus.CREATED);
    }

    // Obtener todas las listas
    @GetMapping
    public List<DramaList> getAllLists() {
        return dramaListService.getLists();
    }

    // obtener lista por id
    @GetMapping("/listById") 
    public Optional<DramaList> getListById(@RequestParam("id") Long dramaId) {
        return dramaListService.listById(dramaId);
    }

    // eliminar una lista por id
    @DeleteMapping("/{list_id}")
    public void deleteListById(@PathVariable("list_id") Long listId) {
        dramaListService.deleteList(listId);
    }

    // modificar una lista por id
    @PutMapping("/{list_id}")
    public DramaList modifyListById(@PathVariable("list_id") Long listId, @RequestBody DramaList dramaList) {
        return dramaListService.updateList(listId, dramaList);
    }

    // agregar dramas a la lista
    @PutMapping("/{list_id}/drama/{drama_id}")
    public DramaList addDramaToList(@PathVariable("list_id") Long listId, @PathVariable("drama_id") Kdrama drama_id) {
        return dramaListService.addDramaToList(listId, drama_id);
    }

    // eliminar dramas de una lista
}