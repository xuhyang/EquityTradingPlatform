package com.tripPropper.orderExecution;

import com.tripPropper.Application;
import com.tripPropper.business.models.Trade;
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
import org.springframework.util.FileSystemUtils;

import javax.jms.ConnectionFactory;
import java.io.File;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
/**
 * Created by admin on 7/30/2016.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class OrderExecutionTests {

    public static void main(String[] args) {

        //FileSystemUtils.deleteRecursively(new File("activemq-data"));
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        TradePublisher tradePublisher = context.getBean(TradePublisher.class);

        Trade trade = new Trade();
        trade.setId(new Random().nextInt());
        trade.setBuy(true);
        trade.setPrice(20.2);
        trade.setSize(1);
        trade.setStock("AAPL");
        trade.setWhenAsDate(new Date());

        tradePublisher.submit(trade);


    }

}
