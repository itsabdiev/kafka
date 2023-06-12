package com.example.apachekafka.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "prime_heroes")
@Entity
public class PrimeHero {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String skill_name;
    private Integer damage;

}
