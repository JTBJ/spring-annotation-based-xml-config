package com.spring.annotation_based_xml_config.dependencyImpl;

import com.spring.annotation_based_xml_config.dependency.FortuneService;
import org.springframework.stereotype.Service;

@Service
public class RESTFortuneServiceImpl implements FortuneService {

    @Override
    public String getFortune() {
        return null;
    }
}
