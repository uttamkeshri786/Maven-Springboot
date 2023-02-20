package com.springboot.uttamkeshri.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.springboot.uttamkeshri.jms.Account;
import com.springboot.uttamkeshri.output.CustomerOutput;
import com.springboot.uttamkeshri.repository.JPARepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Uttam
 */

/** @Entity annotation defines that a
 *  class can be mapped to a table
 */
@Entity
//public final class Customer implements JPARepository<Customer, Long> {
public final class Customer implements JPARepository<Account, CustomerOutput> {      
    /*
     * @ID This annotation specifies 
     * the primary key of the entity.
     */
    
    @Id 
    /*
     * @GeneratedValue This annotation 
     * is used to specify the primary 
     * key generation strategy to use
     */

    /*
     * @GeneratedValue This annotation
     * is used to specify the primary 
     * key generation strategy to use
     */
    
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int customerId;
    private String customerName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;
    private String email;
    
    /**
     * @param typeOf instance
     */
    private Account inputData;
    private CustomerOutput outputData = new CustomerOutput();
    private Map<String, Object> rawData = new HashMap<String, Object>();

    public Customer() {
        super();
    }

    public Customer(int customerId, String customerName, String email, LocalDate dateOfBirth) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       
    public final Account getInputData() {
          return inputData;
    }
  
    @Override
    public final void setInputData(Account inputData) {
        this.inputData = inputData;
    }
    
//  @Override
    public CustomerOutput getOutputData() {
        return outputData;
    }
    
    public void setOutputData(CustomerOutput outputData) {
        this.outputData = outputData;
    }
  
    public final Map<String, Object> getRawData() {
        return rawData;
    }

    public final void setRawData(Map<String, Object> rawData) {
        this.rawData = rawData;
    }
}