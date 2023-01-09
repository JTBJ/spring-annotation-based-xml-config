package com.spring.annotation_based_xml_config.coachImpl;


import com.spring.annotation_based_xml_config.coach.Coach;
import com.spring.annotation_based_xml_config.dependency.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Autowired
    @Qualifier(value = "randomFortuneServiceImpl")
    private FortuneService fortuneService;

    @Value(value = "${spring.annotation.based.xml.config.email}")
    private String emailAddress;

    @Value(value = "${spring.annotation.based.xml.config.team}")
    private String team;

    //placing emphasis on no-arg constructor for setter injection
    public CricketCoach() {

    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    @Override
    public String getDailyFortune() {
        return "Cricket coach " + fortuneService.getFortune();
    }
}
