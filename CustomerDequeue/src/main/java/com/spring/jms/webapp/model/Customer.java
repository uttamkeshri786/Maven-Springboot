package com.spring.jms.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.jms.webapp.jms.EventNotificationService;
import com.spring.jms.webapp.output.CustomerOutput;
import com.spring.jms.webapp.service.IServiceData;

/**
 * @author Uttam
 */

/** @Entity annotation defines that a
 *  class can be mapped to a table
 */
@Entity
     
public final class Customer implements IServiceData<EventNotificationService, CustomerOutput> { 
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
    //private String customerName;
    private String firstname;
    private String surname;
    private String email;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dob;
    private String address;
    private String postcode;
    private String city;
    private String country;
    
    /**
     * @param typeOf instance
     */
    private EventNotificationService inputData;
    private CustomerOutput outputData = new CustomerOutput();
    private Map<String, Object> rawData = new HashMap<String, Object>();

    public Customer() {
        super();
    }

    public Customer(int customerId, String firstname, String surname, String email, LocalDate dob) {
        super();
        this.customerId = customerId;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.dob = dob;       
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

//    public String getCustomerName() {
//        return customerName;
//    }
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Customer customer = (Customer) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
            .append(customerId, customer.customerId)
            .append(firstname, customer.firstname)
            .append(surname, customer.surname)
            .append(dob, customer.dob)
            .append(email, customer.email)
            .append(address, customer.address)
            .append(postcode, customer.postcode)
            .append(city, customer.city)
            .append(country, customer.country)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
            .append(customerId)
            .append(firstname)
            .append(surname)
            .append(dob)
            .append(email)
            .append(address)
            .append(postcode)
            .append(city)
            .append(country)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("customerId", customerId)
            .append("firstname", firstname)
            .append("surname", surname)
            .append("dob", dob)
            .append("email", email)
            .append("address", address)
            .append("postcode", postcode)
            .append("city", city)
            .append("country", country)
            .toString();
    }

    public final EventNotificationService getInputData() {
          return inputData;
    }
  
    @Override
    public final void setInputData(EventNotificationService inputData) {
        this.inputData = inputData;
    }
    
    @Override
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

    public ArrayList<Customer> findAllCustomer() {
        // TODO Auto-generated method stub
        return null;
    }
}