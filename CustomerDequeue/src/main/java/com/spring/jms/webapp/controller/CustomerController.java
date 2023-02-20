package com.spring.jms.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.jms.webapp.model.Customer;
import com.spring.jms.webapp.resource.CustomerResource;
import com.spring.jms.webapp.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index(@ModelAttribute("model") ModelMap model) {

        model.addAttribute("customers", customerService.findAll());

        return "index"; // redirect the current web page session to home
    }

    @PostMapping("/add")
    public String add(Customer customer) {
        
        customerService.add(customer);
        
        return "redirect:/";
    }

    @GetMapping("/delete/{customerId}")
    public String delete(@PathVariable int customerId) {

        customerService.remove(customerId);

        return "redirect:/";
    }
    
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        List<CustomerResource> customerResources = CustomerResourceMapper.mapCustomersToCustomerResources(customers);
        return ResponseEntity.ok(customerResources);
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody CustomerResource customerResource) {
        @SuppressWarnings("unused")
        Customer customer = CustomerResourceMapper.mapCustomerResourceToCustomer(customerResource);
//        customerService.createCustomer(customer);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PathVariable("customerId") int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        CustomerResource customerResource = CustomerResourceMapper.mapCustomerToCustomerResource(customer);
        return ResponseEntity.ok(customerResource);
    }

    @RequestMapping(value = "/customer/{customerId}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerResource customerResource) {
        Customer customer = CustomerResourceMapper.mapCustomerResourceToCustomer(customerResource);
        customerService.updateCustomer(customer);
        return ResponseEntity.ok().build();
    }

}