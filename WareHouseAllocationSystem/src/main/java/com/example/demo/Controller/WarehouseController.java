package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.WareHouse;
import com.example.demo.Service.WareHouseService;

@RestController
@RequestMapping("warehouses")
public class WarehouseController {
 @Autowired
 private WareHouseService warehouseservice;
 
 @PostMapping
 public WareHouse addWarehouse(@RequestBody WareHouse warehouse)
 {
	 return warehouseservice.addWarehouse(warehouse);
 }
 
 @GetMapping
 public List<WareHouse>getAll()
 {
	 return warehouseservice.getAllWarehouse();
 }
 @GetMapping("/{id}")
 public WareHouse getById(@PathVariable Long id)
 {
	 return warehouseservice.getWarehouse(id);
 }
@PutMapping("/{id}")
public WareHouse update(@PathVariable Long id,@RequestBody WareHouse warehouse)
{
	return warehouseservice.updateWarehouse(id, warehouse);
}

@DeleteMapping("/{id}")
public String delete(@PathVariable Long id)
{
	warehouseservice.deleteWarehouse(id);
	return "Warehouse Deactivated";
}


}

