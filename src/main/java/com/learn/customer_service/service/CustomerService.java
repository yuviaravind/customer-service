package com.learn.customer_service.service;

import com.learn.customer_service.dao.CustomerDao;
import com.learn.customer_service.model.Customer;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomer();
    }

    public List<Customer> getCustomerByEmail(String email) {
        return customerDao.getCustomerByEmail(email);
    }

    public List<Customer> getCustomerByName(String name) {
        return customerDao.getCustomerByName(name);
    }

    public Customer postCustomer(Customer customer) {
        return customerDao.postCustomer(customer);
    }

    public UpdateResult updateCustomerById(Long id, Customer customer) {
        return customerDao.updateCustomerById(id, customer);
    }

    public UpdateResult deleteCustomerById(Long id) {
        return customerDao.deleteCustomerById(id);
    }
}
