package com.tripPropper.orderExecution;

import com.tripPropper.business.api.TradesManager;
import com.tripPropper.business.models.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.logging.Level;

/**
 * Created by admin on 7/30/2016.
 */

@Component
public class TradePublisher {

    @Autowired
    JmsTemplate jmsTemplate;

    private JAXBContext context;


    {
        try {
            context = JAXBContext.newInstance (Trade.class);
        } catch (Exception ex) {}
    }


    public void submit(Trade trade) {
        MessageCreator messageCreator = session -> {
            TextMessage textMessage = session.createTextMessage(convertTradeToXML(trade));
            textMessage.setJMSCorrelationID("TripPropper");
            return textMessage;
        };

        jmsTemplate.send("OrderBroker", messageCreator);

        System.out.println("[Trade Publisher] Sending a new trade.");
    }

    private String convertTradeToXML(Trade trade) {
        try (StringWriter out = new StringWriter ()) {
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(trade, out);
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @Deprecated
    public void submit() {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };

        System.out.println("Sending a new message.");
        jmsTemplate.send("mailbox-destination", messageCreator);
    }
}

