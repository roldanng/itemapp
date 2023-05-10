package com.grapsi.itemapp.service;

import com.grapsi.itemapp.exceptions.ItemExceptions;
import com.grapsi.itemapp.mapper.ItemInDTOToItem;
import com.grapsi.itemapp.persistence.entity.Item;
import com.grapsi.itemapp.persistence.repository.ItemRepository;
import com.grapsi.itemapp.service.dto.ItemInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private  final ItemRepository repository;
    private final ItemInDTOToItem mapper;

    public ItemService(ItemRepository repository, ItemInDTOToItem mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Create
    public Item createItem(ItemInDTO itemInDTO){
        Item item = mapper.map(itemInDTO);
        return this.repository.save(item);
    }

    //Get All

    public List<Item> findAll(){
        return this.repository.findAll();
    }

    // FindById
    public Optional<Item> findById(Long id){
        Optional<Item> optionalItem =  this.repository.findById(id);

        if (optionalItem.isEmpty()){
            throw new ItemExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        return this.repository.findById(id);
    }


    //Update
    @Transactional
    public void update(Long id){
        Optional<Item> optionalItem =  this.repository.findById(id);

        if (optionalItem.isEmpty()){
            throw new ItemExceptions("Item not found", HttpStatus.NOT_FOUND);
        }
        this.repository.update(id);
    }

        // Delete
    public void deleteById(Long id){
        Optional<Item> optionalItem =  this.repository.findById(id);

        if (optionalItem.isEmpty()){
            throw new ItemExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }



}
