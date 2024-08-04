package com.learn.customer_service.dao;

import com.learn.customer_service.model.Customer;
import com.mongodb.client.result.UpdateResult;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomer();
    List<Customer> getCustomerByEmail(String email);
    Customer postCustomer(Customer customer);
    UpdateResult updateCustomerById(Long id, Customer customer);
    UpdateResult deleteCustomerById(Long id);
}
