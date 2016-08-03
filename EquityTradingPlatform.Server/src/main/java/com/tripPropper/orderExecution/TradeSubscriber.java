package com.tripPropper.orderExecution;

import com.tripPropper.business.api.AccountManager;
import com.tripPropper.business.api.TradesManager;
import com.tripPropper.business.models.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXB;
import java.io.StringReader;


/**
 * Created by xy30164 on 8/1/2016.
 */

@Component
public class TradeSubscriber implements SessionAwareMessageListener<TextMessage> {

    @Autowired
    TradesManager tradesManager;

    @Autowired
    AccountManager accountManager;

    public TradeSubscriber() {}


    @Override
    public void onMessage(TextMessage message, Session session) throws JMSException {
        String msg = message.getText();
        Trade trade = convertXMLTOTrade(msg);
        Trade.Result result = trade.getResult();

        tradesManager.addResponse(trade);

        if (result == Trade.Result.FILLED || result == Trade.Result.PARTIALLY_FILLED)
            accountManager.updateBalance(trade.getPrice(), trade.getSize(), trade.isBuy());

        System.out.println("[TradeSubscriber] trade's result received: " + result.toString());
    }


    private Trade convertXMLTOTrade(String message) {
        Trade trade = JAXB.unmarshal(new StringReader(message), Trade.class);
        return trade;
    }
}