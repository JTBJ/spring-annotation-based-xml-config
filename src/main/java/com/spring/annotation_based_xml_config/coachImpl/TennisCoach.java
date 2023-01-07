package com.spring.annotation_based_xml_config.coachImpl;

import com.spring.annotation_based_xml_config.coach.Coach;
import org.springframework.stereotype.Component;

@Component(value = "customTennisCoach")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your back hand volley.";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
