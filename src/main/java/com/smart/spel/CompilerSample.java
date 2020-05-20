package com.smart.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class CompilerSample {
    public static void main(String[] args) {
        User user = new User();
        //create configuration
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, CompilerSample.class.getClassLoader());

        //create parser
        SpelExpressionParser parser = new SpelExpressionParser(config);

        //create context
        EvaluationContext context = new StandardEvaluationContext(user);

        //create expression
        String expression = "isVIP('Han') || isVIP('Peter')";

        //parsing expression
        SpelExpression spelExpression = parser.parseRaw(expression);

        //get value
        System.out.println(spelExpression.getValue(context));
        System.out.println(spelExpression.getValue(context));
    }
}
