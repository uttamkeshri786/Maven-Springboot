package com.spring.jms.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.spring.jms.webapp.model.Customer;
import com.spring.jms.webapp.resource.CustomerResource;

public final class CustomerResourceMapper {

    private CustomerResourceMapper(){
    }

    public static CustomerResource mapCustomerToCustomerResource(Customer customer){
        CustomerResource customerResource = new CustomerResource();
        customerResource.setCustomerId(customer.getCustomerId());
        customerResource.setFirstname(customer.getFirstname());
        customerResource.setSurname(customer.getSurname());
        customerResource.setDob(customer.getDob());
        customerResource.setEmail(customer.getEmail());
        customerResource.setAddress(customer.getAddress());
        customerResource.setPostcode(customer.getPostcode());
        customerResource.setCity(customer.getCity());
        customerResource.setCountry(customer.getCountry());
        return customerResource;
    }

    public static Customer mapCustomerResourceToCustomer(CustomerResource customerResource){
        Customer customer = new Customer();
        customer.setCustomerId(customerResource.getCustomerId());
        customer.setFirstname(customerResource.getFirstname());
        customer.setSurname(customerResource.getSurname());
        customer.setDob(customerResource.getDob());
        customer.setEmail(customerResource.getEmail());
        customer.setAddress(customerResource.getAddress());
        customer.setPostcode(customerResource.getPostcode());
        customer.setCity(customerResource.getCity());
        customer.setCountry(customerResource.getCountry());
        return customer;
    }

    public static List<CustomerResource> mapCustomersToCustomerResources(List<Customer> customers) {
        List<CustomerResource> customerResources = new ArrayList<CustomerResource>();
        for (Customer customer : customers){
            customerResources.add(mapCustomerToCustomerResource(customer));
        }
        return customerResources;
    }

    public static List<Customer> mapCustomerResourcesToCustomers(List<CustomerResource> customerResources) {
        List<Customer> customers = new ArrayList<Customer>();
        for (CustomerResource customerResource : customerResources) {
            customers.add(mapCustomerResourceToCustomer(customerResource));
        }
        return customers;
    }
}

