package com.example.demohotelapi.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    private String localizacao;
    @OneToMany(mappedBy = "hotel_id")
    private List<Quarto> quartos;

}

