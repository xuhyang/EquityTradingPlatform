package com.tripPropper.orderExecution;

import com.tripPropper.business.api.TradesManager;
import com.tripPropper.business.models.Trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.List;
import javax.xml.bind.JAXB;


@Deprecated
public class TradeSubscriberOld {

//   private List<Trade> answeredTrades;
//
//
//    @Autowired
//    public TradeSubscriberOld(TradesManager tradesManager) {
//        this.answeredTrades = tradesManager.getAnsweredTrades();
//    }
//
//
//    @JmsListener(destination = "queue/testQueue", containerFactory = "myJmsContainerFactory")
//    public void receiveMessage(String message) {
//        answeredTrades.add(convertXMLTOTrade(message));
//    }
//
//    private Trade convertXMLTOTrade(String message) {
//        Trade trade = JAXB.unmarshal(new StringReader(message), Trade.class);
//        return trade;
//    }
//

}
