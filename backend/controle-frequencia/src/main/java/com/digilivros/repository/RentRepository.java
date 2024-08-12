package com.digilivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digilivros.models.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {

}
