package com.example.demohotelapi.repository;

import com.example.demohotelapi.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
