package com.example.flightbookingmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.flightbookingmanager.entity.Seats;

public interface SeatsRepository extends JpaRepository<Seats, Integer>{
	
}