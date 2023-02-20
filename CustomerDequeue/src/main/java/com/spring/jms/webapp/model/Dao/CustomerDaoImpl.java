package com.spring.jms.webapp.model.Dao;
//package com.springboot.uttamkeshri.model.Dao;
//
//import oracle.jdbc.rowset.OracleCachedRowSet;
//
////import com.datastax.driver.core.Cluster;
//
//import oracle.jms.AQjmsSession;
//import java.time.LocalDate;
////import com.datastax.driver.core.LocalDate;
////import com.datastax.driver.core.ResultSet;
////import com.datastax.driver.core.Row;
////import com.datastax.driver.core.Session;
////import com.mycompany.user.dao.mapper.CassandraRowMapper;
//
//import com.springboot.uttamkeshri.model.Customer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import javax.sql.RowSet;
//
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public abstract class CustomerDaoImpl implements CustomerDao {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);
//
//    private static final String SELECT_ALL_CUSTOMERS_QUERY = "SELECT * FROM customerKS.CUSTOMERS";
//    @SuppressWarnings("unused")
//    private static final String SELECT_CUSTOMER_WITH_CUSTOMERID = "SELECT * FROM customerKS.CUSTOMERS where CUSTOMERID = ";
//    private static final String DELETE_CUSTOMER = "DELETE FROM customerKS.CUSTOMERS where CUSTOMERID = ";
//    private static final String INSERT_CUSTOMER = "INSERT INTO customerKS.CUSTOMERS (CUSTOMERID, firstname, surname, dob, address, postcode, city, country) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
//
////    private Cluster cluster = null;
//    private AQjmsSession session = null;
//
//    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
////    @Value("${db.cassandra.host:127.0.0.1}")
////    private String dbHost;
//
//    private CustomerRowMapper customerRowMapper = new CustomerRowMapper();
//
//    @PostConstruct
//    public void setUp(){
//
//          String dbHost = System.getenv("SQL_HOST");
////
////        cluster = Cluster.builder().addContactPoint(dbHost == null ? this.dbHost : dbHost).build();
////        session = cluster.connect();
//    }
//
//    @PreDestroy
//    public void tearDown() {
////        if (cluster != null) {
////            cluster.close();
////        }
//    }
//    
//    @Override
//    public List<Customer> getCustomers() {
//
//        List<Customer> customers = new ArrayList<Customer>();
//
//        LOGGER.info("Executing CQL: {}", SELECT_ALL_CUSTOMERS_QUERY);
//
//        RowSet rowset = new OracleCachedRowSet ();
//        rowset.setUrl ("jdbc:oracle:oci:@");
//        rowset.setUsername ("admin");
//        rowset.setPassword ("ExperianMA_98");
//        rowset.setCommand ("SELECT_ALL_CUSTOMERS_QUERY");
//        rowset.execute ();
//        while (rowset.next ())
//        {
//          System.out.println ("customerId: " +rowset.getInt (1));
//          System.out.println ("firstname: " +rowset.getString (2) + "lastname : " +rowset.getString(3));
//          System.out.println ("email: "   +rowset.getString(4));
//        }
//        
//        ResultSet rs = session.execute(SELECT_ALL_CUSTOMERS_QUERY);
//
//        for (RowSet row : rs) {
//            Customer customer = customerRowMapper.mapRow(row);
//
//            LOGGER.debug("Retrieved user {} from datastore", customer);
//
//            customers.add(customer);
//        }
//
//        return customers;
//    }
//
//    @Override
//    public Customer getCustomer (String customerId) {
//
//        String selectCustomerWithId = SELECT_CUSTOMER_WITH_ID +customerId;
//
//        LOGGER.info("Executing CQL: {}", selectCustomerWithId);
//
//        ResultSet rs = session.execute(selectUserWithId);
//        Row row = rs.one();
//
//        Customer customer = userRowMapper.mapRow(row);
//
//        LOGGER.info("Retrieved user %s from datastore", customer);
//
//        return customer;
//    }
//
//    @Override
//    public void saveCustomer(Customer customer) {
//        String saveCustomerCql = String.format(INSERT_CUSTOMER, customer.getCustomerId(), customer.getFirstname(), customer.getSurname(),
//            formatter.format(customer.getDob()), customer.getPostcode(), customer.getAddress(), customer.getCity(), customer.getCountry());
//
//        LOGGER.info("Executing CQL: {}", saveCustomerCql);
//
//        session.execute(saveCustomerCql);
//    }
//
//    @Override
//    public void deleteCustomer(String customerid) {
//        String deleteCustomerWithId = DELETE_CUSTOMER + customerId;
//
//        LOGGER.info("Executing CQL: {}" + deleteCustomerWithId);
//
//        session.execute(deleteCustomerWithId);
//    }
//
//    @SuppressWarnings("rawtypes")
//    private static class CustomerRowMapper implements RowMapper{
//
//        @Override
//        public Customer mapRow(Row row) {
//            Customer customer = new Customer();
//            customer.setCustomerId(row.getString("customerId"));
//            customer.setFirstname(row.getString("forename"));
//            customer.setSurname(row.getString("surname"));
//
//            LocalDate dateFromDB = row.getDate("dob");
//            /*
//             * SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//             * Date date = new Date(); System.out.println(formatter.format(date));
//             */  
//            Date dateTime = new dateTime(dateFromDB.getYear(), dateFromDB.getMonth(), dateFromDB.getDay(), 0, 0, 0);
//
//            customer.setDob(dateTime.toLocalDate());
//            customer.setAddress(row.getString("address"));
//            customer.setPostcode(row.getString("postcode"));
//            customer.setCity(row.getString("city"));
//            customer.setCountry(row.getString("country"));
//            return customer;
//        }
//    }
//
//}
//
