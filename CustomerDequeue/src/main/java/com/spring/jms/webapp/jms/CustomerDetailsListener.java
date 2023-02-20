package com.spring.jms.webapp.jms;

import org.slf4j.LoggerFactory;

import com.spring.jms.webapp.model.Customer;
import com.spring.jms.webapp.output.CustomerOutput;

public final class CustomerDetailsListener extends AbstractMessageListener<EventNotificationService, Customer> {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerDetailsListener.class);
    
    @Override
    protected Customer getProcessObject(EventNotificationService msg) throws Exception {
        
        LOGGER.info("Message recieved successfully");
        LOGGER.info("Customer Id is: {}", msg.getNotificationId());
        Customer customerData = new Customer();
        customerData.setInputData(msg);
        customerData.setOutputData(new CustomerOutput());
        customerData.getRawData().put("CUSTNO", msg.getNotificationId());
        return customerData;

    }

    @Override
    protected void execute(Customer processObject) {
        // TODO Auto-generated method stub
        
    }
}