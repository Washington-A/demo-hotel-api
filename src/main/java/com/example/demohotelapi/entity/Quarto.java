package com.example.demohotelapi.entity;

import jakarta.persistence.*;

import lombok.*;

@Table(name = "quarto")
@Entity(name = "Quarto")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int hotel_id;
}