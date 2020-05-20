package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class MethodExprSample {
    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //invoke string method
        String substring = (String) parser.parseExpression("'Spring SpEL'.substring(7)").getValue();
        System.out.println("substring -->" + substring);

        //invoke indexOf
        Integer indexof = parser.parseExpression("'Spring SpEL'.indexOf('SpEL')").getValue(Integer.class);
        System.out.println("indexof -->" + indexof);

        //invoke instance method
        boolean isVIP = parser.parseExpression("isVIP('Peter')").getValue(context,Boolean.class);
        System.out.println("isVIP -->" + isVIP);
    }
}
