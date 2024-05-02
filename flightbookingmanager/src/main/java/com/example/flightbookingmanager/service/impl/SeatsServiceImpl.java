package com.example.flightbookingmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.SeatsRepository;
import com.example.flightbookingmanager.entity.Seats;
import com.example.flightbookingmanager.exception.FlightNotFoundException;
import com.example.flightbookingmanager.exception.SeatsNotFoundException;
import com.example.flightbookingmanager.service.SeatsService;

import jakarta.transaction.Transactional;

@Service
public class SeatsServiceImpl implements SeatsService{

	@Autowired
	SeatsRepository seatsRepository;
	
	@Transactional
	@Override
	public Seats seats(Seats seats) {
		return seatsRepository.save(seats);
	}
	
	@Transactional
	@Override
	public List<Seats>addSeats(){
		return seatsRepository.findAll();
	}
	
	@Transactional
	@Override
	public Seats getSeatsByFlightId(Integer id) throws SeatsNotFoundException, FlightNotFoundException {
		Seats seats = seatsRepository.findById(id).orElse(null);
		if(seats!=null) {
			return seats;
		}
		throw new SeatsNotFoundException("No seats Available!!!");
	}
}
