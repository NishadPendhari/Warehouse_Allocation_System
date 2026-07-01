package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.StockTransfer;
import com.example.demo.Entity.WareHouse;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.WarehouseInventory;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.StockTransferRepository;
import com.example.demo.Repository.WareHouseRepository;
import com.example.demo.Repository.WarehouseInventoryRepository;

@Service
public class StockTransferService {
	@Autowired
	private ProductRepository productrepository;
	
	@Autowired
	private WareHouseRepository warehouserepository;
	
	@Autowired
	private WarehouseInventoryRepository warehouseinventoryrepository;
	
	@Autowired
	private StockTransferRepository stocktransferrepository;
	
	public StockTransfer transfer(Long sourceId,Long targetId,Long productId,Integer quantity)
	{
		WareHouse source=warehouserepository.findById(sourceId).orElseThrow();
		WareHouse target=warehouserepository.findById(targetId).orElseThrow();
	Product  product=productrepository.findById(productId).orElseThrow();
		
		WarehouseInventory sourceInventory=warehouseinventoryrepository.findByWarehouseAndProduct(source,product).orElseThrow();
		
		WarehouseInventory targetInventory=warehouseinventoryrepository.findByWarehouseAndProduct(target, product).orElseThrow();
		
		if(sourceInventory.getAvailableQty()<quantity)
		{
			throw new RuntimeException("Insufficient Stock");
		}
		sourceInventory.setAvailableQty(sourceInventory.getAvailableQty()-quantity);
		targetInventory.setAvailableQty(targetInventory.getAvailableQty()+ quantity);
		
		warehouseinventoryrepository.save(sourceInventory);
		warehouseinventoryrepository.save(targetInventory);
		
		StockTransfer stocktransfer=new StockTransfer();
		stocktransfer.setSourceWarehouse(source);
		stocktransfer.setTargetWarehouse(target);
		stocktransfer.setProduct(product);
		stocktransfer.setQuantity(quantity);
		return stocktransferrepository.save(stocktransfer);
		
	}
}
