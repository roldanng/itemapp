package com.grapsi.itemapp.controller;

import com.grapsi.itemapp.persistence.entity.Item;
import com.grapsi.itemapp.service.ItemService;
import com.grapsi.itemapp.service.dto.ItemInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item CreateItem(@RequestBody ItemInDTO itemInDTO){
        return this.itemService.createItem(itemInDTO);
    }

    @GetMapping
    public List<Item> findAll(){
        return this.itemService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Item> findById(@PathVariable("id") Long id){
        return this.itemService.findById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id){
        this.itemService.update(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.itemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
