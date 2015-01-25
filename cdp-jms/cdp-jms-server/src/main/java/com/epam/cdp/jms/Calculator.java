package com.epam.cdp.jms;

import java.io.Serializable;

/**
 * Created by Ilya_Kukushkin on 1/17/2015
 */
public class Calculator {

    public static abstract class Operation implements Serializable {

        private String name;

        public Operation(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        abstract double eval(double х, double у);

        public static final Operation PLUS = new Operation("+") {
            @Override
            double eval(double x, double y) {
                return x + y;
            }
        };

        public static final Operation MINUS = new Operation("-") {
            @Override
            double eval(double x, double y) {
                return x - y;
            }
        };

        public static final Operation MULTIPLY = new Operation("*") {
            @Override
            double eval(double x, double y) {
                return x * y;
            }
        };

        public static final Operation DIVIDE = new Operation("/") {
            @Override
            double eval(double x, double y) {
                return x / y;
            }
        };
    }

    public double calculate(double x, Operation op, double y) {
        return op.eval(x, y);
    }
}
