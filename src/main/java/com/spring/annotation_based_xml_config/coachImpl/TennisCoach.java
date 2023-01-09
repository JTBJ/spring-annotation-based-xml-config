package com.spring.annotation_based_xml_config.coachImpl;

import com.spring.annotation_based_xml_config.coach.Coach;
import com.spring.annotation_based_xml_config.dependency.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "customTennisCoach")
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    //explicitly defining a default constructor
    public TennisCoach() {}

    @Override
    public String getDailyWorkout() {
        return "Practice your back hand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Autowired
    public void setFortuneService(@Qualifier(value = "happyFortuneServiceImpl") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
