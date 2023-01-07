package com.spring.annotation_based_xml_config.coachImpl;


import com.spring.annotation_based_xml_config.coach.Coach;
import com.spring.annotation_based_xml_config.dependency.FortuneService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

    @Override
    public String getDailyFortune() {
        return "Track coach " + fortuneService.getFortune();
    }

    private void init() {
        System.out.println("***** lifecycle method init(); on prototype bean example  *****");
        System.out.println("inside of lifecycle method init(); on prototype scoped bean");
        System.out.println();
    }

//    @Override
    public void destroy() {
        System.out.println("***** lifecycle method destroy(); on prototype bean example  *****");
        System.out.println("inside of lifecycle method destroy(); on prototype scoped bean");
        System.out.println("Bean reference " + this);
        System.out.println("The prototype scoped beans MUST implement the DisposableBean interface.\n" +
                            "in order for destroy(); callback to execute. This interface defines a \n" +
                            "\"destroy()\" method.");
        System.out.println();
    }
}
