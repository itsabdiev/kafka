package com.example.apachekafka.repository;

import com.example.apachekafka.model.PrimeHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<PrimeHero,Long> {

}
