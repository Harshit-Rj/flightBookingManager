package com.example.flightbookingmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.FlightsRepository;
import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.exception.FlightNotFoundException;
import com.example.flightbookingmanager.service.FlightsService;

import jakarta.transaction.Transactional;

@Service
public class FlightsServiceImpl implements FlightsService{

	@Autowired
	FlightsRepository flightsRepository;
	
	@Transactional
	@Override
	public Flights addFlights(Flights flights) {
		return flightsRepository.save(flights);
	}
	
	@Transactional
	@Override
	public List<Flights> getAllFlights(){
		return flightsRepository.findAll();
	}
	

	@Transactional
	@Override
	public Flights getFlightsById(int id) throws FlightNotFoundException {
		Flights flights = flightsRepository.findById(id).orElse(null);
		if(flights!=null) {
			return flights;
		}
		throw new FlightNotFoundException("No flights found!!");
	}
	
	@Transactional
	@Override
	public List<Flights> getAllFlightsByRoute(String departureCity, String arrivalCity ) {
		return flightsRepository.getAllFlightsByRoute(departureCity, arrivalCity);
	}
	
	@Transactional
	@Override
	public List<Flights> sortAllFlightsByRoute(String departureCity, String arrivalCity ) {
		return flightsRepository.sortAllFlightsByRoute(departureCity, arrivalCity);
	}

}
