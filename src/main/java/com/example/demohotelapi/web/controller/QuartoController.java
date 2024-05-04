package com.example.demohotelapi.web.controller;

import com.example.demohotelapi.entity.Quarto;
import com.example.demohotelapi.service.QuartoService;
import com.example.demohotelapi.web.dto.QuartoResponseDto;
import com.example.demohotelapi.web.dto.mapper.QuartoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/hoteis/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    @Operation(summary = "Listar quartos por disponibilidade",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista os quartos disponíveis em uma data específica",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = QuartoResponseDto.class)))),

                    @ApiResponse(responseCode = "400", description = "Erro na busca, a data fornecida pode ser inválida",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Error.class))))
            }
    )
    @GetMapping("/disponibilidade/{checkIn},{checkOut}")
    public ResponseEntity<List<QuartoResponseDto>> getByAvailability(@PathVariable LocalDate checkIn, @PathVariable LocalDate checkOut) {
        List<Quarto> quartos = quartoService.buscarPorDisponibilidade(checkIn, checkOut);
        return ResponseEntity.ok(QuartoMapper.toListDto(quartos));
    }
}
