package com.example.demohotelapi.web.controller;

import com.example.demohotelapi.entity.Hotel;
import com.example.demohotelapi.service.HotelService;
import com.example.demohotelapi.web.dto.HotelResponseDto;
import com.example.demohotelapi.web.dto.mapper.HotelMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/hoteis")
public class HotelController {

    private final HotelService hotelService;
    @Operation(summary = "Listar todos os hotéis",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista com todos os hotéis cadastrados",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = HotelResponseDto.class)))),

                    @ApiResponse(responseCode = "400", description = "Nenhum hotel cadastrado",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Error.class))))

            }
    )
    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAll() {
        List<Hotel> hoteis = hotelService.buscarTodos();
        return ResponseEntity.ok(HotelMapper.toListDto(hoteis));
    }


    @Operation(summary = "Listar hotel por id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Hotel encontrado",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = HotelResponseDto.class)))),

                    @ApiResponse(responseCode = "404", description = "Hotel não encontrado",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Error.class))))

            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDto> getById(@PathVariable int id) {
        Hotel hotel = hotelService.buscarPorId(id);
        return ResponseEntity.ok(HotelMapper.toDto(hotel));
    }


    @Operation(summary = "Listar hotéis por localização", description = "Listar hotéis por localização",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista os hotéis com base em um termo que contenha parcialmente o nome da localização",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = HotelResponseDto.class))))
            }
    )
    @GetMapping("/localizacao/{local}")
    public ResponseEntity<List<HotelResponseDto>> getByLocation(@PathVariable String local) {
        List<Hotel> hoteis = hotelService.buscarPorLocalizacao(local);
        return ResponseEntity.ok(HotelMapper.toListDto(hoteis));
    }


    @Operation(summary = "Listar hotéis por disponibilidade", description = "Listar hotéis pela disponibilidade de quartos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista os hotéis com base na disponibilidade de quartos em uma data específica",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = HotelResponseDto.class)))),

                    @ApiResponse(responseCode = "400", description = "Erro na busca, a data fornecida pode ser inválida",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Error.class))))
            }
    )
    @GetMapping("/disponibilidade/{checkIn},{checkOut}")
    public ResponseEntity<List<HotelResponseDto>> getByAvailability(@PathVariable LocalDate checkIn, @PathVariable LocalDate checkOut) {
        List<Hotel> hoteis = hotelService.buscarPorDisponibilidade(checkIn,checkOut);
        return ResponseEntity.ok(HotelMapper.toListDto(hoteis));
    }
}
