package com.example.demohotelapi.web.dto.mapper;

import com.example.demohotelapi.entity.Quarto;
import com.example.demohotelapi.web.dto.QuartoResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class QuartoMapper {

    public static QuartoResponseDto toDto(Quarto quarto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(quarto, QuartoResponseDto.class);
    }

    public static List<QuartoResponseDto> toListDto(List<Quarto> quartos) {
        return quartos.stream().map(QuartoMapper::toDto).collect(Collectors.toList());
    }
}

