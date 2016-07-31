package com.tripPropper.orderExecution;

import com.tripPropper.business.api.TradesManager;
import com.tripPropper.business.models.Trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Component
public class TradeSubscriber {

    List<Trade> answeredTrade;


    @Autowired
    public TradeSubscriber(TradesManager tradesManager) {
        this.answeredTrade = tradesManager.getAnsweredTrades();
    }


    @JmsListener(destination = "mailbox-destination", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
//
//
    }

    private Trade convertXMLTOTrade() {
        Trade trade = null;
        return  trade;
    }


}
