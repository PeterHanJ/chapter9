package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ElvisExprSample {
    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //Elvis Expression
        String elvisExpression = "userName?:'UNKNOWN'";

        user.setUserName("Peter");
        String userName = parser.parseExpression(elvisExpression).getValue(context,String.class);
        System.out.println("user name --> " + userName);

        user.setUserName(null);
        userName = parser.parseExpression(elvisExpression).getValue(context,String.class);
        System.out.println("user name -->" + userName);

    }
}
