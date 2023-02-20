package com.spring.jms.webapp.jms;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jms.AQjmsException;

/*
 * @Abstract: JMS
 */

@SuppressWarnings("unused")
public abstract class AbstractMessageListener<M, D> {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AbstractMessageListener.class);
    
    public void onMessage(Message message) { 
        TextMessage msg = null; 
        try { 
            if (message instanceof TextMessage) { 
                msg = (TextMessage) message; 
                 System.out.println("Reading message: " + msg.getText()); 
            } else { 
                 System.out.println("Message is not a " + "TextMessage"); 
            } 
        } catch (AQjmsException e) { 
            System.out.println("JMSException in onMessage(): " + e.toString()); 
        } catch (Throwable t) { 
            System.out.println("Exception in onMessage():" + t.getMessage()); 
        }
    }
    
    public final void OnMesasge(final M msg) throws Exception {
        
        try {
            
            D processObject = getProcessObject(msg);
            execute(processObject);
            
        }catch(Exception ex) {
/*          ex.getStackTrace();
            ((Object) ex).logger("Error handling for JMS", ex);*/
            LOGGER.error("Error handling JMS message", ex);
            throw ex;
        }   
    }
    
    /*Execute Utility Method*/
    protected abstract void execute(D processObject);

    protected abstract D getProcessObject(M msg) throws Exception;
    
}