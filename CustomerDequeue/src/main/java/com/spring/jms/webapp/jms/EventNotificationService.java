package com.spring.jms.webapp.jms;

/**
 * @author Uttam
 *
 */
public final class EventNotificationService {
    
    private Long notificationId;
    
    /**
     * set the default constructor 
     * @empty
     */
    public EventNotificationService() {
        
    }
    
    public Long getNotificationId() {
        return notificationId;
    }
    
    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }
    
    /**
    *@param represent any object as a string
    *@return values of the object
    */
    @Override
    public String toString() {
        return "Notification: {notificationId= " + notificationId + "}";
    }
    
}