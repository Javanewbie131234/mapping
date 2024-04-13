package com.mapping.mapping.controller;

import com.mapping.mapping.Dto.CustomerDTO;
import com.mapping.mapping.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")

public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/placeorder")
    public ResponseEntity<?> saveOrder(@RequestBody CustomerDTO customerDTO){
        CustomerDTO createCustomer = customerService.saveOrder(customerDTO);
        if(createCustomer!=null){
            return ResponseEntity.ok(createCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrder(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }



}
