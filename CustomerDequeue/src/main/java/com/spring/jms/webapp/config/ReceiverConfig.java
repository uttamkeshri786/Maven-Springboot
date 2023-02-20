package com.spring.jms.webapp.config;

//import org.apache.activemq.ActiveMQConnectionFactory;
import oracle.jms.AQjmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

@Configuration
@EnableJms
public class ReceiverConfig {

//    @Value("${activemq.broker-url}")
//    private String brokerUrl;

    @Value("{aq.broker-url}")
    private String brokerUrl;
    
    @Value("${destination.status1}")
    private String status1Destination;

    @Value("${destination.status2}")
    private String status2Destination;


    /*
     * AQjms message broker
     */
    
     @Bean public AQjmsConnectionFactory receiverAQjmsConnectionFactory() {
          AQjmsConnectionFactory aqjmsConnectionFactory = new AQjmsConnectionFactory();
//          aqjmsConnectionFactory.setBrokerURL(brokerUrl); 
          return aqjmsConnectionFactory; 
      }     

     @Bean
     public DefaultJmsListenerContainerFactory orderDefaultJmsListenerContainerFactory() {
     DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
     factory.setConnectionFactory(receiverAQjmsConnectionFactory());
     factory.setConcurrency("3-10");
     return factory;
     }

    @Bean
    public SimpleJmsListenerContainerFactory orderSimpleJmsListenerContainerFactory() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory
                .setConnectionFactory(receiverAQjmsConnectionFactory());

        return factory;
    }

    /* DefaultMessageListener-Container */
    @Bean
    public DefaultMessageListenerContainer orderMessageListenerContainer() {
        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
//            endpoint.setMessageListener(new StatusMessageListener("DMLC"));
        endpoint.setMessageListener(null);
        endpoint.setDestination(status1Destination);

        return orderDefaultJmsListenerContainerFactory()
                .createListenerContainer(endpoint);
    }

    /* SimpleMessageListener-Container */
    @Bean
    public SimpleMessageListenerContainer statusMessageListenerContainer() {
        SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
//            endpoint.setMessageListener(new StatusMessageListener("SMLC"));
            endpoint.setMessageListener(null);
        endpoint.setDestination(status2Destination);
        
        return orderSimpleJmsListenerContainerFactory()
                .createListenerContainer(endpoint);
    }
}
