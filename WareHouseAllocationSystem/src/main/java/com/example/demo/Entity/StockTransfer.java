package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StockTransfer {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="source_warehouse_id")
	private WareHouse sourceWarehouse;
	
	@ManyToOne
	@JoinColumn(name="target_warehouse_id")
	private WareHouse targetWarehouse;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private Integer quantity;
	private LocalDateTime transferDate;
	
	public StockTransfer()
	{
		this.transferDate=LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WareHouse getSourceWarehouse() {
		return sourceWarehouse;
	}

	public void setSourceWarehouse(WareHouse sourceWarehouse) {
		this.sourceWarehouse = sourceWarehouse;
	}

	public WareHouse getTargetWarehouse() {
		return targetWarehouse;
	}

	public void setTargetWarehouse(WareHouse targetWarehouse) {
		this.targetWarehouse = targetWarehouse;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDateTime transferDate) {
		this.transferDate = transferDate;
	}
	

}
