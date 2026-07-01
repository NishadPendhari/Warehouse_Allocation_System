package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.WareHouse;
import com.example.demo.Repository.WareHouseRepository;

@Service
public class WareHouseService {
	@Autowired
  private WareHouseRepository warehouserepository;
	
	public WareHouse addWarehouse(WareHouse warehouse)
	{
		return warehouserepository.save(warehouse);
	}
  
	public List<WareHouse>getAllWarehouse()
	{
		return warehouserepository.findAll();
	}
	public WareHouse getWarehouse(Long id)
	{
		return warehouserepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
	}
	public WareHouse updateWarehouse(Long id,WareHouse warehouse)
	{
		WareHouse existing=getWarehouse(id);
		existing.setName(warehouse.getName());
		existing.setLocation(warehouse.getLocation());
		existing.setCapacity(warehouse.getCapacity());
		existing.setStatus(warehouse.getStatus());
		
		return warehouserepository.save(existing);
		
	}
	public void deleteWarehouse(Long id)
	{
		WareHouse warehouse=getWarehouse(id);
		warehouse.setStatus("INACTIVE");
		warehouserepository.save(warehouse);
			
	}
	
	
	
	
	
	
	
	
}
