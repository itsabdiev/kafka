package com.example.apachekafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Random;

@Configuration
public class ApacheTopicConfig {


    @Bean
    public NewTopic apacheTopic() {
        return TopicBuilder.name("apacheTopic").build();
    }

    @Bean
    public Random random() {
        return new Random();
    }


}
