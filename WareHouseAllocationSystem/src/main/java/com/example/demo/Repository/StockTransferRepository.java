package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.StockTransfer;

public interface StockTransferRepository extends JpaRepository<StockTransfer,Long> {

}
