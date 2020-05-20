package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;

public class PropertyExprSample {
    public static void main(String[] args) {
        //create an object
        User user = new User();
        user.setUserName("Peter");
        user.setLastVisit(new Date());
        user.setCredits(100);
        user.setPlaceOfBirth(new PlaceOfBirth("China","Suzhou"));

        //create parser
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //get value
        String userName = (String)parser.parseExpression("userName").getValue(context);
        System.out.println("User Name -->" + userName);

        int credits = (Integer) parser.parseExpression("credits + 20").getValue(context);
        System.out.println("Credits -->" + credits);

        String city = (String)parser.parseExpression("placeOfBirth.city").getValue(context);
        System.out.println("Birth City -->" + city);
    }
}
