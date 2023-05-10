package com.grapsi.itemapp.mapper;

import com.grapsi.itemapp.persistence.entity.Item;
import com.grapsi.itemapp.service.dto.ItemInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ItemInDTOToItem implements IMapper<ItemInDTO, Item> {
    @Override
    public Item map(ItemInDTO in) {
        Item item = new Item();
        item.setNombre(in.getNombre());
        item.setDescription(in.getDescription());
        item.setPrecio(in.getPrecio());
        item.setModelo(in.getModelo());
        item.setCreatedDate(LocalDateTime.now());
        return item;
    }
}
