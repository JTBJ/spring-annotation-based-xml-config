package com.spring.annotation_based_xml_config;

import com.spring.annotation_based_xml_config.coach.Coach;
import com.spring.annotation_based_xml_config.coachImpl.BaseballCoach;
import com.spring.annotation_based_xml_config.coachImpl.CricketCoach;
import com.spring.annotation_based_xml_config.coachImpl.TennisCoach;
import com.spring.annotation_based_xml_config.coachImpl.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        // load the container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from container
        Coach tCoach = context.getBean("customTennisCoach", Coach.class);
        Coach bbCoach = context.getBean("baseballCoach", Coach.class); // uses default bean id classname lowercase "b"
        Coach trCoach = context.getBean("trackCoach", Coach.class);
        Coach cCoach = context.getBean("cricketCoach", Coach.class);

        // call methods on the bean
        System.out.println(tCoach.getDailyWorkout());
        System.out.println(bbCoach.getDailyWorkout());
        System.out.println(trCoach.getDailyWorkout());
        System.out.println(cCoach.getDailyWorkout());
        System.out.println();

        //call dependency method
        System.out.println("***** Dependency injection using qualifiers *****");
        System.out.println("BaseballCoach Constructor injection: " + bbCoach.getDailyFortune());
        System.out.println("TennisCoach Setter injection: " + tCoach.getDailyFortune());
        System.out.println("TrackCoach Method level injection: " + trCoach.getDailyFortune());
        System.out.println("CricketCoach Field injection: " + cCoach.getDailyFortune());
        System.out.println();

        //call properties set
        System.out.println(((CricketCoach)cCoach).getEmailAddress());
        System.out.println(((CricketCoach)cCoach).getTeam());

        // close the context
        context.close();
    }
}
