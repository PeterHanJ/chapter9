package com.smart.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELTest {

    /*
     * Bean config in xml
     */
    @Test
    public void testXML(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        ShapeGuess shapeGuess = context.getBean("shapeGuess",ShapeGuess.class);
        System.out.println(shapeGuess.getInitialShapeSeed());

    }

    @Test
    public void testValueAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:smart-context.xml");
        MyDataSource myDataSource = context.getBean("myDataSource",MyDataSource.class);

        System.out.println("Drive Class Name:" + myDataSource.getDriverClassName());
        System.out.println("Url:" + myDataSource.getUrl());
        System.out.println("User Name:" + myDataSource.getUserName());
        System.out.println("Password:" + myDataSource.getPassword());

    }
}
