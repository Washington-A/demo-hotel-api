package com.example.demohotelapi.web.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotelResponseDto {
    private int id;
    private String nome;
    private String localizacao;
    private List<QuartoResponseDto> quartos;

}
