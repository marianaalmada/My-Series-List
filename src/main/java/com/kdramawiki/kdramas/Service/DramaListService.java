package com.kdramawiki.kdramas.Service;

import java.util.List;
import java.util.Optional;

import com.kdramawiki.kdramas.Entity.DramaList;
import com.kdramawiki.kdramas.Entity.Kdrama;
import com.kdramawiki.kdramas.Entity.User;
import com.kdramawiki.kdramas.Repository.DramaListRepository;
import com.kdramawiki.kdramas.Repository.KdramaRepository;
import com.kdramawiki.kdramas.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DramaListService {
    private final DramaListRepository dramaListRepository;
    private final UserRepository userRepository;
    private final KdramaRepository kdramaRepository;

    @Autowired
    public DramaListService(DramaListRepository dramaListRepository, UserRepository userRepository,
            KdramaRepository kdramaRepository) {
        this.dramaListRepository = dramaListRepository;
        this.userRepository = userRepository;
        this.kdramaRepository = kdramaRepository;
    }

    /*@Autowired
    public DramaListService(DramaListRepository dramaListRepository, UserRepository userRepository) {
        this.dramaListRepository = dramaListRepository;
        this.userRepository = userRepository;
    }*/

    // crear una lista
    public DramaList createList(Long userId, DramaList list) { 
        User user = userRepository.getById(userId);
        list.setuser(user);
        return dramaListRepository.save(list);
    }

    // Obtener todas las listas
    public List<DramaList> getLists() {
        List<DramaList> lists = dramaListRepository.findAll();
        return lists;
    }

    // obtener lista por id
    public Optional<DramaList> listById(Long dramaId) {
        return dramaListRepository.findById(dramaId);
    }

    // eliminar una lista por id
    public void deleteList(Long listId) {
        dramaListRepository.deleteById(listId);
    }

    // modificar una lista por id
    public DramaList updateList(Long listId, DramaList dramaList, Kdrama drama) {
        DramaList list = dramaListRepository.getById(listId);
        list.setName(dramaList.getName());
        list.addDrama(drama);
        return dramaListRepository.save(list);
    }

    // eliminar dramas de una lista SOLUCIONAR
    public void deleteDramaFromList(Long listId, Long dramaId) {
        DramaList list = dramaListRepository.getById(listId);
        Kdrama drama = kdramaRepository.getById(dramaId);
        list.removeDrama(drama);
        dramaListRepository.save(list);
    }

    // buscar lista por nombre
    public DramaList listByName(String name) {
        return dramaListRepository.findByName(name);
    }

    // Obtener todas las listas de un usuario
    public List<DramaList> listCreatedByUser(Long user_id) {
        User user = userRepository.getById(user_id);
        return user.getList_created();
    }
}