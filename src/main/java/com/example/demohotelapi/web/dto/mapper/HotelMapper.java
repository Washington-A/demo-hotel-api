package com.example.demohotelapi.web.dto.mapper;

import com.example.demohotelapi.entity.Hotel;
import com.example.demohotelapi.web.dto.HotelResponseDto;
import com.example.demohotelapi.web.dto.QuartoResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class HotelMapper {

    public static HotelResponseDto toDto(Hotel hotel) {
        ModelMapper mapper = new ModelMapper();

        HotelResponseDto hotelDto = mapper.map(hotel, HotelResponseDto.class);

        hotelDto.setQuartos(hotel.getQuartos().stream()
                .map(quarto -> mapper.map(quarto, QuartoResponseDto.class))
                .collect(Collectors.toList()));

        return hotelDto;
    }

    public static List<HotelResponseDto> toListDto(List<Hotel> hoteis) {
        return hoteis.stream().map(hotel -> toDto(hotel)).collect(Collectors.toList());
    }

}
