package com.example.demohotelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demohotelapi.entity.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query("select h from Hotel h where h.localizacao like %:localizacao%")
    List<Hotel> findByLocation(String localizacao);

}
