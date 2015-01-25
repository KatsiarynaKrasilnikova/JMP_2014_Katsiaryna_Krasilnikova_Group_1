package com.epam.cdp.jms;

import java.io.Serializable;

/**
 * Created by Ilya_Kukushkin on 1/25/2015
 */
public class CalculatorBean implements Serializable {

    private double x;
    private double y;
    private Calculator.Operation operation;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Calculator.Operation getOperation() {
        return operation;
    }

    public void setOperation(Calculator.Operation operation) {
        this.operation = operation;
    }
}
