package com.spring.jms.webapp.model.Dao;

import java.util.List;

import com.spring.jms.webapp.model.Customer;

public interface CustomerDao {

    List<Customer> getCustomers();
    
    Customer getUser(String customerId);

    void saveCustomer(Customer customer);

    void deleteCustomer(String customerId);
    
}