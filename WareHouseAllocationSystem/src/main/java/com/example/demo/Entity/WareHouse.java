package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WareHouse {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
   private String name;
   private String location;
   private Integer capacity;
   private LocalDateTime cratedAt;
   private String status;
   
   public WareHouse()
   {
	   this.cratedAt=LocalDateTime.now();
   }

   public Long getId() {
	return id;
   }

   public void setId(Long id) {
	this.id = id;
   }

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public String getLocation() {
	return location;
   }

   public void setLocation(String location) {
	this.location = location;
   }

   public Integer getCapacity() {
	return capacity;
   }

   public void setCapacity(Integer capacity) {
	this.capacity = capacity;
   }

   public LocalDateTime getCratedAt() {
	return cratedAt;
   }

   public void setCratedAt(LocalDateTime cratedAt) {
	this.cratedAt = cratedAt;
   }

   public String getStatus() {
	return status;
   }

   public void setStatus(String status) {
	this.status = status;
   }
   
   
}
