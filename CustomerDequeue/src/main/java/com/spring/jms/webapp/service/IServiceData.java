package com.spring.jms.webapp.service;

import com.spring.jms.webapp.jms.EventNotificationService;
import com.spring.jms.webapp.output.CustomerOutput;

public interface IServiceData<IN, OUT> {

    void setInputData(EventNotificationService inputData);
    
    CustomerOutput getOutputData();
}
