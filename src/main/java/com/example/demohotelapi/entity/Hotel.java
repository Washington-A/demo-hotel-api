package com.example.demohotelapi.entity;

import jakarta.persistence.*;

import lombok.*;

@Table(name = "hotel")
@Entity(name = "hotel")
@EqualsAndHashCode(of= "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String cidade;
    private int qtdQuartos;
    private boolean isDisponible;
}

