package com.example.demohotelapi.domain.hotel;

import jakarta.persistence.*;
import java.util.UUID;

import lombok.*;

@Table(name = "hotel")
@Entity(name = "hotel")
@EqualsAndHashCode(of= "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelModel  {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String cidade;
    private int qtdQuartos;
    private boolean isDisponible;


}

