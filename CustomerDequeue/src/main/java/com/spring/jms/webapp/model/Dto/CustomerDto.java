package com.spring.jms.webapp.model.Dto;

import java.io.Serializable;
import java.util.Date;

//import com.springboot.user.dto.AddressDto;

@SuppressWarnings("serial")
public class CustomerDto implements Serializable {
    
    private String customerId;
    private String firstname;
    private String surname;
    private Date dob;
    private String email;

    private AddressDto address;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}