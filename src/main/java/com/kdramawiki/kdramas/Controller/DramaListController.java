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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DramaListController {
    private final DramaListService dramaListService;

    @Autowired
    public DramaListController(DramaListService dramaListService) {
        this.dramaListService = dramaListService;
    }

    // Crear una lista
    @PostMapping("/user/{user_id}/list/")
    public ResponseEntity<?> createNewList(@PathVariable("user_id") Long user_id, @RequestBody DramaList list) {
        return new ResponseEntity<>(dramaListService.createList(user_id, list), HttpStatus.CREATED);
    }

    // Obtener todas las listas
    @GetMapping("/list")
    public List<DramaList> getAllLists() {
        return dramaListService.getLists();
    }

    // obtener lista por id
    @GetMapping("/list/listById") 
    public Optional<DramaList> getListById(@RequestParam("id") Long dramaId) {
        return dramaListService.listById(dramaId);
    }

    // eliminar una lista por id
    @DeleteMapping("/list/{list_id}")
    public void deleteListById(@PathVariable("list_id") Long listId) {
        dramaListService.deleteList(listId);
    }

    // modificar una lista por id y agregar un drama
    @PutMapping("/list/{list_id}/drama/{drama_id}")
    public DramaList modifyListById(@PathVariable("list_id") Long listId, 
                                    @PathVariable("drama_id") Kdrama drama, 
                                    @RequestBody DramaList dramaList) {
        return dramaListService.updateList(listId, dramaList, drama);
    }

    // eliminar dramas de una lista 
    @DeleteMapping("list/{list_id}/drama/{drama_id}") 
    public void deleteDramaFromList(@PathVariable("list_id") Long list_id, Kdrama drama) {
        dramaListService.deleteDramaFromList(list_id, drama);
    }

    // buscar lista por nombre
    @GetMapping("/list/{name}")
    public DramaList getListByName(@RequestParam("name") String name) {
        return dramaListService.listByName(name);
    }

    // Obtener todas las listas creadas por un usuario
    @GetMapping("/user/{user_id}/list")
    public List<DramaList> getListCreatedByUser(@PathVariable("user_id") Long user_id) {
        return dramaListService.listCreatedByUser(user_id);
    }
}