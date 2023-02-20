package com.spring.jms.webapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.jms.webapp.jms.EventNotificationService;
import com.spring.jms.webapp.model.Customer;

/* @Repository is a Spring annotation that indicates
 * that the decorated class is a repository. 
 */

@SuppressWarnings("hiding")
@Repository
public interface CustomerRepository<EventNotificationService, Customer> {
//public interface CustomerRepository extends JPARepository<EventNotificationService, Customer> {
    
    public static final ArrayList<Customer> findAllCustomer = new ArrayList<Customer>();
    

    Optional<Customer> findByEmail(String email);   

    static List<Customer> findByIdIn(List<Long> customerId) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);

    public static void deleteAll() {
        // TODO Auto-generated method stub
        // return;
    }
    
    /*
     * @Query(value =
     * "SELECT * FROM Customer_details arp where arp.customerId=?1 ",nativeQuery =
     * true) List<Customer> findByEmail(String email);
     */
       
//    @Query(value = "SELECT * FROM Customer_details arp where arp.username=?1", nativeQuery = true)
//    List<Customer> findOneByUsername(String username);

//    @Query(value = "SELECT * FROM Customer_details arp where arp.login_attempt_count=?1", nativeQuery = true)
//    List<User> findByLoginAttempt(int loginAttemptExceed);

//    @Query(value = "SELECT * FROM Customer_details arp where arp.status=?1", nativeQuery = true)
//    List<User> findByPendingStatus(int loginPendingStatus);
   
}