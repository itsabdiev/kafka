package com.example.apachekafka.config;


import com.example.apachekafka.model.Hero;
import com.example.apachekafka.model.MessageDto;
import com.example.apachekafka.model.PrimeHero;
import com.example.apachekafka.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class ApacheController {
    private final HeroRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/message")
    public void postMessage(@RequestBody MessageDto message) {
        kafkaTemplate.send("apacheTopic",message);
    }

    @PostMapping("/hero")
    public void postHero(@RequestBody Hero hero) {
        kafkaTemplate.send("apacheTopic",hero);
    }

    @PostMapping("/string/{str}")
    public void postString(@PathVariable(name = "str") String s) {
        kafkaTemplate.send("apacheTopic",s);
    }

    @GetMapping("/message/all")
    public ResponseEntity<List<PrimeHero>> fetchAllHeroes() {
        return ResponseEntity.ok(repository.findAll());
    }
}
