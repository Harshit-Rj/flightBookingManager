package com.example.flightbookingmanager.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.FlightsRepository;
import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.exception.FlightNotFoundException;

import jakarta.transaction.Transactional;

@Service
public interface FlightsService {
	
	public Flights addFlights(Flights flights);
	
	public List<Flights> getAllFlights();
	
	public Flights getFlightsById(int id) throws FlightNotFoundException;
	
	public List<Flights> getAllFlightsByRoute(String departureCity, String arrivalCity );
	
	public List<Flights> sortAllFlightsByRoute(String departureCity, String arrivalCity );
}
