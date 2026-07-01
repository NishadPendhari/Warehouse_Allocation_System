package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Allocation {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	private WareHouse warehouse;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private Integer quantity;
	
	private LocalDateTime allocatedAt;
	
	private String status;
	
	public Allocation()
	{
		this.allocatedAt=LocalDateTime.now();
		this.status="SUCCESS";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WareHouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WareHouse warehouse) {
		this.warehouse = warehouse;
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

	public LocalDateTime getAllocatedAt() {
		return allocatedAt;
	}

	public void setAllocatedAt(LocalDateTime allocatedAt) {
		this.allocatedAt = allocatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
