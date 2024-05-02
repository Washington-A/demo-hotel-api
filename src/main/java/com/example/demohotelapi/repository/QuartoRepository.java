package com.example.demohotelapi.repository;


import com.example.demohotelapi.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, Integer> {

    @Query("SELECT q FROM Quarto q WHERE q.id NOT IN (SELECT r.quartoId FROM Reserva r WHERE (:checkIn BETWEEN r.checkIn AND r.checkOut) AND (:checkOut BETWEEN r.checkIn AND r.checkOut) AND r.status = 'ativa')")
    List<Quarto> findByAvailability(LocalDate checkIn, LocalDate checkOut);
}
