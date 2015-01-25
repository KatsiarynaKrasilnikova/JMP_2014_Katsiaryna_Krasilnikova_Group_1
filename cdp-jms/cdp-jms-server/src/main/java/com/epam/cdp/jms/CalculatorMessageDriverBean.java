package com.epam.cdp.jms;

import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(name = "CalculatorMessageDriverBean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/testTopic")})
public class CalculatorMessageDriverBean implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(CalculatorMessageDriverBean.class);

    @Resource(name = "testTopic")
    private Topic topic;

    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            CalculatorBean calculatorBean = (CalculatorBean) objectMessage.getObject();
            Calculator calculator = new Calculator();
            LOGGER.info(calculator.calculate(calculatorBean.getX(), calculatorBean.getOperation(), calculatorBean.getY()));
        } catch (JMSException e) {
            LOGGER.error(e);
        }
    }
}
