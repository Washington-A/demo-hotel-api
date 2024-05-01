package com.example.demohotelapi.repository;

import com.example.demohotelapi.entity.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReservaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Reserva> getByHotelAndData(LocalDate data, int hotelId){
        String query = "FROM Reserva r WHERE :dataParametro BETWEEN r.checkIn AND r.checkOut AND r.status <> 'finalizada' AND r.hotelId = :hotelId";

        TypedQuery<Reserva> typedQuery = entityManager.createQuery(query, Reserva.class);

        typedQuery.setParameter("dataParametro", data);
        typedQuery.setParameter("hotelId", hotelId);

        return typedQuery.getResultList();
    }
}
