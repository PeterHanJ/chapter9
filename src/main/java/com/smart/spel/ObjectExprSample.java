package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ObjectExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Tom");

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //setValue
        parser.parseExpression("userName").setValue(context, "Peter");
        System.out.println("user name -->" + user.getUserName());

        //expression set value
        parser.parseExpression("userName = 'Han Jun'").getValue(context);
        System.out.println("user name -->" + user.getUserName());

        //load java.lang.String
        Class stringClass = parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(stringClass == java.lang.String.class);

        //load com.smart.spel.User
        Class userClass = parser.parseExpression("T(com.smart.spel.User)").getValue(Class.class);
        System.out.println(userClass == com.smart.spel.User.class);

        try {
            Method isVIP = userClass.getDeclaredMethod("isVIP",String.class);
            User user1 = (User) userClass.newInstance();
            System.out.println("hahaha");
            boolean result = (Boolean) isVIP.invoke(user1,"Peter");
            System.out.println("isVIP :" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //class static method by T()
        Object randomValue = parser.parseExpression("T(java.lang.Math).random()").getValue();
        System.out.println("Random Value = " + randomValue);

        //create instance by constructor
        PlaceOfBirth placeOfBirth = parser.parseExpression("new com.smart.spel.PlaceOfBirth('China','Suzhou')").getValue(PlaceOfBirth.class);
        System.out.println("Place of Birth:" + placeOfBirth.getCountry() + "," + placeOfBirth.getCity());


        //variable expression (#var)
        //set new variable in context
        context.setVariable("newUserName","Gao Shuai");
        //get variable and assignment
        parser.parseExpression("userName=#newUserName").getValue(context);
        System.out.println("user name :" + user.getUserName());

        //this variable expression (#this)
        List<Integer> credits = new ArrayList<Integer>();
        credits.addAll(Arrays.asList(120,110,80,70,125));
        context.setVariable("credits",credits);
        List<Integer> filterList = (List<Integer>) parser.parseExpression("#credits.?[#this>100]").getValue(context);
        System.out.println("filter list -->" + filterList.toString());

        //collection filter (?[selectExpression])
        Map<String,Integer> creditsMap = new HashMap<String,Integer>();
        creditsMap.put("Han Jun",120);
        creditsMap.put("Peter",110);
        creditsMap.put("Gao Shuai",80);
        creditsMap.put("Han Wenyan",150);
        context.setVariable("creditsMap",creditsMap);
        Map<String,Integer> filterMap = (Map<String, Integer>) parser.parseExpression("#creditsMap.?[value>100]").getValue(context);
        System.out.println(filterMap.toString());

        //convert collection  (![projectionExpression])
        //execute [projectionExpression] for each collection's element and return a new collection
        List<Integer> convertList = (List<Integer>) parser.parseExpression("#credits.![#this>100]").getValue(context);
        System.out.println("convert list -->" + convertList.toString());
    }
}
