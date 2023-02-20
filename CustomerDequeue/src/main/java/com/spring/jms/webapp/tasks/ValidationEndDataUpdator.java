package com.spring.jms.webapp.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jms.webapp.model.Customer;

    
public class ValidationEndDataUpdator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationEndDataUpdator.class);
    private JdbcTemplate jdbcTemplate;
    private String updateQuery;

    public final void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public final void setUpdateQuery(String updateQuery) {
        this.updateQuery = updateQuery;
    }

//    @Override
    public final void execute(Customer customerData) throws Exception {
        LOGGER.debug("Validation finished for SERIAL NO. :: {}",
                customerData.getInputData().getNotificationId());

        int rowsUpdated = jdbcTemplate.update(updateQuery, customerData.getInputData().getNotificationId());
        LOGGER.debug("Rows updated:{}", rowsUpdated);

    }

}
