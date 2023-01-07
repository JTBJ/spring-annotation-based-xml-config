package com.spring.annotation_based_xml_config;

import com.spring.annotation_based_xml_config.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        // load the container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from container
        Coach tCoach = context.getBean("customTennisCoach", Coach.class);
        Coach bbCoach = context.getBean("baseballCoach", Coach.class); // uses default bean id classname lowercase "b"

        // call methods on the bean
        System.out.println(tCoach.getDailyWorkout());
        System.out.println(bbCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}
