package com.epam.cdp.jms;

import asg.cliche.Command;
import asg.cliche.ShellFactory;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.IOException;

/**
 * Created by Ilya_Kukushkin on 1/25/2015
 */
public class Main {

    private TopicSendClient client;

    public Main() {
        client = new TopicSendClient();
    }

    @Command(name = "plus")
    public void plus(double x, double y) throws NamingException, JMSException {
        CalculatorBean calculatorBean = new CalculatorBean();
        calculatorBean.setX(x);
        calculatorBean.setY(y);
        calculatorBean.setOperation(Calculator.Operation.PLUS);

        client.sendAsync(calculatorBean);
    }

    @Command(name = "minus")
    public void minus(double x, double y) throws NamingException, JMSException {
        CalculatorBean calculatorBean = new CalculatorBean();
        calculatorBean.setX(x);
        calculatorBean.setY(y);
        calculatorBean.setOperation(Calculator.Operation.MINUS);

        client.sendAsync(calculatorBean);
    }

    @Command(name = "divide")
    public void divide(double x, double y) throws NamingException, JMSException {
        CalculatorBean calculatorBean = new CalculatorBean();
        calculatorBean.setX(x);
        calculatorBean.setY(y);
        calculatorBean.setOperation(Calculator.Operation.DIVIDE);

        client.sendAsync(calculatorBean);
    }

    @Command(name = "multiply")
    public void multiply(double x, double y) throws NamingException, JMSException {
        CalculatorBean calculatorBean = new CalculatorBean();
        calculatorBean.setX(x);
        calculatorBean.setY(y);
        calculatorBean.setOperation(Calculator.Operation.MULTIPLY);

        client.sendAsync(calculatorBean);
    }

    @Command(name = "exit")
    public void exit() throws NamingException, JMSException {
        client.stop();
    }


    public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("calculator", "Type ?list or ?list-all, to see available commands.",
                new Main()).commandLoop();
    }
}
