package com.spring.jms.webapp.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jms.webapp.model.Customer;

/**
 * @author Uttam
 * @implNote DataUpdator:
 * @implSpec JDBC Template - Update query
 *
 */
public class ValidationStartDataUpdator  {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationStartDataUpdator.class);

    private JdbcTemplate jdbcTemplate;
    private String updateQuery;

    public final void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public final void setUpdateQuery(String updateQuery) {
        this.updateQuery = updateQuery;
    }

//    @Override
    public final void execute(Customer data) throws Exception {
        LOGGER.debug("Updating VALIDATION_COUNT for SERIAL NO.: {}", data.getInputData().getNotificationId());

        int rowsUpdated = jdbcTemplate.update(updateQuery, data.getInputData().getNotificationId());
        LOGGER.debug("Rows updated:{}", rowsUpdated);
    }

}
