package com.example.demohotelapi.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelResponseDto {
    private String id;
    private String nome;
    private String cidade;
    private int qtdQuartos;
}
