package com.spring.annotation_based_xml_config.dependencyImpl;

import com.spring.annotation_based_xml_config.dependency.FortuneService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomFortuneServiceImpl implements FortuneService {

    private String[] fortuneArray = {
            "Beware of the wolf in sheep's clothing.",
            "Diligence is the mother of good luck.",
            "The journey is the reward."
    };

    @Override
    public String getFortune() {
        return fortuneArray[new Random().nextInt(3)];
    }
}
