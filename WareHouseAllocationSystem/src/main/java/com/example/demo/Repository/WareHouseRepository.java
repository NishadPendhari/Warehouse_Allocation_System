package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse,Long> {

}
