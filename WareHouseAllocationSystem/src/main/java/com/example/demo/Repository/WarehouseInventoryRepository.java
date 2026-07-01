package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.WareHouse;
import com.example.demo.Entity.WarehouseInventory;

public interface WarehouseInventoryRepository extends JpaRepository<WarehouseInventory,Long> {
    Optional<WarehouseInventory>findByWarehouseAndProduct(WareHouse warehouse,Product product);
}
