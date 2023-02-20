package com.spring.jms.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jms.webapp.model.Customer;
import com.spring.jms.webapp.repository.CustomerRepository;

// @Service marks a Java class that performs some service,
// such as executing business logic, performing
// calculations, and calling external APIs.
@Service
@SuppressWarnings("unused")
//public class CustomerServiceImpl implements CustomerService {
public class CustomerServiceImpl {
        //your code goes here 
}

//  @Autowired
//  CustomerRepository customerRepository;
//  
//  public ArrayList<Customer> findAllCustomer() {
//      return (ArrayList<Customer>) ((CustomerService) customerRepository).findAll();
//  }
//  
//  public Customer findAllCustomerByID(List<Long> id) {
//      List<Customer> opt = CustomerRepository.findByIdIn(id);
//      if (opt.isPresent())
//          return opt.get(0);
//      else
//          return null;
//  }
//  
//  //public Customer(int customerId, String customerName, String email, LocalDate dateOfBirth)
// 
// 
//  @Override
//  public void addCustomer() {
//      ArrayList<Customer> newCustomer = new ArrayList<Customer>();
//      newCustomer.add(new Customer("1", "Saumil Shah", "saumil@bcs.com", "2020-12-06::23:12:08"));
//      newCustomer.add(new Customer("Delhi", "Puneet"));
//      newCustomer.add(new Customer("Pune", "Abhay"));
//      newCustomer.add(new Customer("Noida", "Anurag"));
//      for (Customer customer : newCustomer) {
//          customerRepository.save(customer);
//      }
//  }  
//}
