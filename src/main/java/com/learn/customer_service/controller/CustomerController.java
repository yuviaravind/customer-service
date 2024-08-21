package com.learn.customer_service.controller;

import com.learn.customer_service.exception.HandleNotImplementedException;
import com.learn.customer_service.exception.ResourceNotFoundException;
import com.learn.customer_service.model.Customer;
import com.learn.customer_service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        logger.info("CustomerController(getAllCustomers) --> Enter");
        List<Customer> customerList = customerService.getAllCustomers();
        logger.info("CustomerController(getAllCustomers --> Exit");
        return ResponseEntity.ok().body(customerList);
    }

    @GetMapping("/getCustomerByEmail/{email}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable("email") String email) {
        throw new HandleNotImplementedException("Oops its not implemented yet");
    }

    @GetMapping("/getCustomerByName")
    public ResponseEntity<?> getCustomerByName(@RequestParam(name = "name") String name) {
        if(name.equals("test")) {
            throw new ResourceNotFoundException("Customer not found with the name " + name);
        }
        return ResponseEntity.ok().body(customerService.getCustomerByName(name));
    }
}
