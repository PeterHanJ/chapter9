package com.smart.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class LiteralExprSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        //string
        String helloWorld = (String)parser.parseExpression("\"Hello World\"").getValue();

        //double
        double doubleNumber = (Double)parser.parseExpression("6.0123E+23").getValue();

        //int
        int maxValue = (Integer)parser.parseExpression("0x123").getValue();
        System.out.println(maxValue);

        //boolean
        boolean trueValue = (Boolean)parser.parseExpression("false").getValue();

        //null
        Object nullValue = parser.parseExpression("null").getValue();
    }
}
