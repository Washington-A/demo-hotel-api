package com.example.demohotelapi.web.dto.mapper;

import com.example.demohotelapi.entity.Hotel;
import com.example.demohotelapi.web.dto.HotelResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

public class HotelMapper {

    public static HotelResponseDto toDto(Hotel hotel) {
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<Hotel, HotelResponseDto> propertyMapper = mapperMain.createTypeMap(Hotel.class, HotelResponseDto.class);
        return mapperMain.map(hotel, HotelResponseDto.class);
    }

    public static List<HotelResponseDto> toListDto(List<Hotel> hoteis) {
        return hoteis.stream().map(hotel -> toDto(hotel)).collect(Collectors.toList());
    }

}
