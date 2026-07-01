package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.AllocationRequest;
import com.example.demo.Entity.Allocation;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.WareHouse;
import com.example.demo.Entity.WarehouseInventory;
import com.example.demo.Repository.AllocationRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.WareHouseRepository;
import com.example.demo.Repository.WarehouseInventoryRepository;

@Service
public class AllocationService {

	@Autowired
private AllocationRepository allocationrepository;
    
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private WareHouseRepository warehouserepository;
	
	@Autowired
	private WarehouseInventoryRepository warehouseinventoryrepository;
	
	public Allocation allocateStock(AllocationRequest request)
	{
		Product product=productrepository.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product Not found"));
	
	   List<WareHouse>warehouses=warehouserepository.findAll();
	   
	   for(WareHouse warehouse:warehouses)
	   {
		   WarehouseInventory inventory=warehouseinventoryrepository.findByWarehouseAndProduct(warehouse,product).orElse(null);
		   
		   if(inventory != null && inventory.getAvailableQty()>= request.getQuantity())
		   {
			   inventory.setAvailableQty(inventory.getAvailableQty()- request.getQuantity());
			   warehouseinventoryrepository.save(inventory);
			   
			   Allocation allocation=new Allocation();
			   allocation.setWarehouse(warehouse);
			   allocation.setProduct(product);
			   allocation.setQuantity(request.getQuantity());
			   
			   return allocationrepository.save(allocation);
		   }
	   }
	   throw new RuntimeException("Insufficient Stock");
			 
	}
		
	
}
