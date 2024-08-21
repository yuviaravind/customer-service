package com.learn.customer_service.dao;

import com.learn.customer_service.model.Customer;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomerDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return mongoTemplate.findAll(Customer.class);
    }

    @Override
    public List<Customer> getCustomerByEmail(String email) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("email").is(email),
                Criteria.where("isDeleted").is(false)
        );
        return mongoTemplate.find(new Query(criteria),Customer.class);
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("customerName").is(name),
                Criteria.where("isDeleted").is(false)
        );
        return mongoTemplate.find(new Query(criteria),Customer.class);
    }

    @Override
    public Customer postCustomer(Customer customer) {
        return mongoTemplate.insert(customer);
    }

    @Override
    public UpdateResult updateCustomerById(Long id, Customer customer) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("id").is(id),
                Criteria.where("isDeleted").is(false)
        );
        Update update = new Update();
        update.set("email", customer.getEmail());
        return mongoTemplate.updateFirst(new Query(criteria), update, Customer.class);
    }

    @Override
    public UpdateResult deleteCustomerById(Long id) {
        Criteria criteria = new Criteria().andOperator(
                Criteria.where("id").is(id)
        );
        Update update = new Update();
        update.set("isDeleted", true);
        return mongoTemplate.updateFirst(new Query(criteria), update, Customer.class);
    }
}
