package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SafeExprExample {
    public static void main(String[] args) {
        User user = new User();
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        user.setPlaceOfBirth(null);
        //safe to null
        String city = parser.parseExpression("placeOfBirth?.city").getValue(context,String.class);
        System.out.println("city -->" + city);

        user.setPlaceOfBirth(new PlaceOfBirth("China",null));
        city = parser.parseExpression("placeOfBirth?.city").getValue(context,String.class);
        System.out.println("city -->" + city);
    }
}
