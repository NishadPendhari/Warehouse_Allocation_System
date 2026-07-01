package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.AllocationRequest;
import com.example.demo.Entity.Allocation;
import com.example.demo.Service.AllocationService;

@RestController
@RequestMapping("/allocations")
public class AllocationController {
   @Autowired
   private AllocationService allocationservice;
   
   @PostMapping
   public Allocation allocate(@RequestBody AllocationRequest request)
   {
	   return allocationservice.allocateStock(request);
   }
   
}
