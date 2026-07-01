package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {

}
