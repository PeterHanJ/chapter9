package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExprSample {
    public static void main(String[] args) {
        User user = new User();
        user.setInterestsArray(new String[]{"sing","travel","dance"});
        List interestsList = new ArrayList();
        interestsList.add("sing");
        interestsList.add("dance");
        interestsList.add("travel");
        user.setInterestsList(interestsList);

        Map interestsMap = new HashMap();
        interestsMap.put("int1","sing");
        interestsMap.put("int2","dance");
        interestsMap.put("int3","travel");
        user.setInterestsMap(interestsMap);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);

        //parsing array
        int[] array1 = (int[])parser.parseExpression("new int[]{1,2,3}").getValue();
        System.out.println("array[0] -->"+array1[0]);
        int[][] array2 = (int[][])parser.parseExpression("new int[2][3]").getValue();
        //not support multi-dimensional array initialize
        //int[][] array3 = (int[][])parser.parseExpression("new int[2][3]{{1,2,3},{4,5,6}}").getValue();

        //parsing list
        List list = (List)parser.parseExpression("{1,2,3,4}").getValue();
        System.out.println("List get(0) -->" + list.get(0));

        List listOfList = (List)parser.parseExpression("{{'a','b'},{'x','y'}}").getValue();
        System.out.println("List get(1).get(1)-->" + ((List)listOfList.get(1)).get(1));

        //collection string parsing
        Map userinfo = (Map)parser.parseExpression("{userName:'Peter',credits:100}").getValue(context);
        System.out.println("userinfo -->" + userinfo.get("userName"));

        List userinfo2 = (List)parser.parseExpression("{{userName:'tom',credits:90},{userName:'peter',credits:100}}").getValue();
        System.out.println("userinfo2 -->" + ((Map)userinfo2.get(1)).get("credits"));

        //get value from array,map,list
        String interest1 = (String) parser.parseExpression("interestsArray[0]").getValue(context);
        System.out.println("interest1 -->" + interest1);

        String interest2 = (String) parser.parseExpression("interestsList[1]").getValue(context);
        System.out.println("interest2 -->" + interest2);

        String interest3= (String) parser.parseExpression("interestsMap['int3']").getValue(context);
        System.out.println("interest3 -->" + interest3);
    }
}
