package com.grapsi.itemapp.persistence.repository;

import com.grapsi.itemapp.persistence.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying
    @Query(value = "UPDATE ITEM SET DESCRIPTION= 'Nueva descripcion' WHERE ID=:id", nativeQuery = true)

    public void update(@Param("id") Long id);
}
