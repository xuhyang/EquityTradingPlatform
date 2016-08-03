package com.tripPropper.config;



import com.tripPropper.orderExecution.TradeSubscriber;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.Queue;

/**
 * Created by xy30164 on 8/1/2016.
 */

@Configuration

public class JmsConfig {

    @Autowired
    private TradeSubscriber tradeSubscriber;

    @Bean
    public ActiveMQConnectionFactory amqConnectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(amqConnectionFactory());
    }

    @Bean
     public ActiveMQQueue defaultDestination() {
        return new ActiveMQQueue("OrderBroker");
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestination(defaultDestination());

        return jmsTemplate;
    }

    @Bean
    DefaultMessageListenerContainer messageListenerContainer() {
        DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory());
        messageListenerContainer.setDestinationName("OrderBroker_Reply");
        messageListenerContainer.setMessageListener(tradeSubscriber);

        return messageListenerContainer;
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("queue/testQueue");
    }


}
