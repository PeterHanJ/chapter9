package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class OperatorExprSample {
    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);
        //= <
        boolean trueValue = parser.parseExpression("2==2").getValue(Boolean.class);
        boolean falseValue = parser.parseExpression("2<-0.5").getValue(Boolean.class);
        System.out.println("trueValue-->" + trueValue);
        System.out.println("falseValue-->" + falseValue);

        //instanceof
        boolean instanceofValue = parser.parseExpression("12 instanceof T(Integer)").getValue(Boolean.class);
        System.out.println("instanceofValue-->" + instanceofValue);

        //and &&
        boolean falseValue1 = parser.parseExpression("true && false").getValue(Boolean.class);
        System.out.println("falseValue1-->" + falseValue1);

        boolean falseValue2 = parser.parseExpression("isVIP('Peter') and isVIP('Han')").getValue(context,Boolean.class);
        System.out.println("falseValue2-->" + falseValue2);

        //or ||
        boolean trueValue1 = parser.parseExpression("true || false").getValue(Boolean.class);
        System.out.println("trueValue1-->" + trueValue1);

        boolean trueValue2 = parser.parseExpression("isVIP('Peter') or isVIP('Han')").getValue(context,Boolean.class);
        System.out.println("trueValue2-->" + trueValue2);

        //!
        boolean trueValue3 = parser.parseExpression("!false").getValue(Boolean.class);
        System.out.println("trueValue3-->" + trueValue3);

        //+
        int two = parser.parseExpression("1+1").getValue(Integer.class);
        System.out.println("two-->"+two);

        String testStr = parser.parseExpression("\"test\" + ' ' + \"String\"").getValue(String.class);
        System.out.println("testStr-->"+testStr);

        //-
        int four = parser.parseExpression("1 - -3").getValue(Integer.class);
        System.out.println("four-->"+four);

        //*
        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class);
        System.out.println("twentyFour-->"+twentyFour);

        // /
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class);
        System.out.println("minusTwo-->"+minusTwo);

        // %
        int three = parser.parseExpression("7 % 4").getValue(Integer.class);
        System.out.println("three-->"+three);

        //-21
        int result = parser.parseExpression("1+2-3*8").getValue(Integer.class);
        System.out.println("result-->"+result);

    }
}
