package com.spring.jms.webapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.jms.webapp.config.*;
import com.spring.jms.webapp.model.Customer;
import com.spring.jms.webapp.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.*;

import java.lang.Deprecated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Service

//@Slf4j
//private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    private static List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer(101, "Uttam", "Keshri", "uttam.keshri@bcssarl.com", LocalDate.of(1998, 05, 15)));
        customers.add(new Customer(201, "Nilesh", "Pawar", "nilesh@microsoft.com", LocalDate.of(1993, 10, 28)));
        customers.add(new Customer(201, "Shweta", "Pawar", "shweta@gmail.com", LocalDate.of(1996, 8, 21)));
        customers.add(new Customer(201, "Kishan", "Panchal", "kishan@abc.xyz", LocalDate.of(1989, 3, 16)));
    }

    public List<Customer> findAll() {
        return customers;
    }
    
//  @Override
    public List<Customer> findAll(String email) {
        return customers;
    }
    
    public List<Customer> doesNotContain(String email) {
        List<Customer> arr = new ArrayList<Customer>();
        boolean ans = arr.isEmpty();
        if (ans == true)
            System.out.println("Customer list is empty");
        else
            System.out.println("Customer list is not empty");
        return customers;
    }

    /**
     * @param customer
     * @GeneratedValue CustomerId
     */
    public void add(Customer customer) {
        customer.setCustomerId(generateRandomId());

        customers.add(customer);
    }

    private int generateRandomId() {

        return new Random().nextInt(1000);
    }

    public void deleteAllData() { 
//        CustomerRepository.deleteAll(); 
    }
    
    public List<Customer> remove(int customerId) {
        customers.removeIf(c -> c.getCustomerId() == customerId);
        return findAll();
    }

    public Optional<Customer> find(int customerId) {
        
        return customers.stream().filter(c -> c.getCustomerId() == customerId).findFirst();
    }
    
    /*
     * @Default-Methods: TODO 
     */
    public void createCustomer(Customer customer) {
        // TODO Auto-generated method stub
    }
    
    public Customer getCustomer(int customerId) {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteCustomer(int customerId) {
        // TODO Auto-generated method stub
    }

    public void updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
    }

    public List<Customer> getCustomers() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    /*
     * public Optional<Customer> findAll(int customerId, String email) { return
     * customers.stream().filter(c -> c.getCustomerId() == customerId, c->
     * c.getCustomerEmail() == email); }
     */
     
    
    /*
     * public static final Set<String> mySet == new HashSet<String>() {
     * mySet.add("generateRandomId"); }
     */
}