package com.example.demohotelapi.repositories;

import com.example.demohotelapi.domain.hotel.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelsRepository extends JpaRepository<HotelModel, String> {
}
