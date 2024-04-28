package com.example.demohotelapi.entity;



import jakarta.persistence.*;
import lombok.*;


@Table(name = "hotel")
@Entity(name = "Hotel")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int qtd_quartos;
    private String localizacao;

}

