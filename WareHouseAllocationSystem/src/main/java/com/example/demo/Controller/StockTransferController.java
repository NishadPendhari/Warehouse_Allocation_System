package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.StockTransfer;
import com.example.demo.Service.StockTransferService;

@RestController
@RequestMapping("/stocktransfer")
public class StockTransferController {

	@Autowired
	private StockTransferService stocktransferservice;
	
	@PostMapping
	public StockTransfer transfer(@RequestParam Long sourceWarehouseId,@RequestParam Long targetWarehouseId ,@RequestParam Long productId,@RequestParam Integer quantity)
	{
	  return stocktransferservice.transfer(sourceWarehouseId,targetWarehouseId,productId,quantity);
	}
	
	
}
