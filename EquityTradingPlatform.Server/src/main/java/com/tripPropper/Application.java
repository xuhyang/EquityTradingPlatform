package com.tripPropper;

import com.tripPropper.business.models.Trade;
import com.tripPropper.orderExecution.TradePublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.File;
import java.util.Date;
import java.util.Random;
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class Application {

//    @Bean // Strictly speaking this bean is not necessary as boot creates a default
//    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        return factory;
//    }

    public static void main(String[] args) {

//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        TradePublisher tradePublisher = context.getBean(TradePublisher.class);
//
//        Trade trade = new Trade();
//        trade.setId(new Random().nextInt());
//        trade.setBuy(true);
//        trade.setPrice(20.2);
//        trade.setSize(1);
//        trade.setStock("AAPL");
//        trade.setWhenAsDate(new Date());
//
//        tradePublisher.submit(trade);
    }

}
