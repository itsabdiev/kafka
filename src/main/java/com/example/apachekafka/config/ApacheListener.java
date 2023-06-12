package com.example.apachekafka.config;



import com.example.apachekafka.model.Hero;
import com.example.apachekafka.model.MessageDto;
import com.example.apachekafka.model.PrimeHero;
import com.example.apachekafka.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@KafkaListener(topics = "apacheTopic",groupId = "groupId")
@RequiredArgsConstructor
public class ApacheListener {
    private final HeroRepository repository;
    private final Random random;

    @KafkaHandler()
    void listener(MessageDto messageDto) {
        System.out.println(messageDto);
    }

    @KafkaHandler()
    void listener1(Hero hero) {
        System.out.println("Hero has been accepted successfully!");
        PrimeHero primeHero = PrimeHero.builder()
                .name(hero.getName())
                .skill_name(hero.getPower())
                .damage(random.nextInt(0,100))
                .build();
        repository.save(primeHero);
        System.out.println("Prime hero has been saved");
    }

    @KafkaHandler(isDefault = true)
    void listener(Object o) {
        System.out.println(o);
    }
}
