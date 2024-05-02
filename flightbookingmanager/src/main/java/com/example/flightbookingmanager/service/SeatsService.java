package com.example.flightbookingmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.SeatsRepository;
import com.example.flightbookingmanager.entity.Seats;
import com.example.flightbookingmanager.exception.FlightNotFoundException;
import com.example.flightbookingmanager.exception.SeatsNotFoundException;

@Service

public interface SeatsService {

	public Seats seats(Seats seats);
	
	public List<Seats>addSeats();
	
	public Seats getSeatsByFlightId(Integer id) throws SeatsNotFoundException, FlightNotFoundException ;

}
