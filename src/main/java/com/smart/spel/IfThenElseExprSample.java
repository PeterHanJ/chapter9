package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class IfThenElseExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Peter");
        user.setCredits(80);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        String expression = "userName=='Peter'?credits+10:credits";
        int credits = parser.parseExpression(expression).getValue(context, Integer.class);
        System.out.println("credits --> " + credits);
    }
}
