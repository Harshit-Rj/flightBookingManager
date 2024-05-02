package com.example.flightbookingmanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.exception.FlightNotFoundException;
import com.example.flightbookingmanager.model.FlightInputModel;
import com.example.flightbookingmanager.model.PassengerInputModel;
import com.example.flightbookingmanager.service.FlightsService;

@RestController
public class FlightsController {

	Logger logger = LoggerFactory.getLogger(PassengerController.class);
	
	@Autowired
	FlightsService flightsService;
	
	@PostMapping("/addflights")
	public ResponseEntity<Flights> addFlights(@RequestBody FlightInputModel flights) {
		Flights f = new Flights();
		f.setId(flights.getId());
		f.setDepartureDate(flights.getDepartureDate());
		f.setDepartureTime(flights.getDepartureTime());
		f.setDepartureCity(flights.getDepartureCity());
		f.setArrivalDate(flights.getArrivalDate());
		
		
		logger.info("Flights Added"+ f.getId());
		return new ResponseEntity<Flights>(f, HttpStatus.OK);
	}
	
	@GetMapping("/getflightsbyid/{id}")
	public Flights getFlightsById(@PathVariable int id) throws FlightNotFoundException {
		Flights flights = flightsService.getFlightsById(id);
		
		logger.info("Details of Flight of given ID : "+ flights);
		return flights;
	}
	
	@GetMapping("/getallflightsofroute/{departurecity}/{arrivalcity}")
	public List<Flights> getAllFlightsByRoute(@PathVariable("departurecity") String departureCity,@PathVariable("arrivalcity") String arrivalCity ){
		
		logger.info("All flights by route returned");
		return flightsService.getAllFlightsByRoute(departureCity, arrivalCity);
	}
	
	@GetMapping("/sortallflightsofroutebyprice/{departurecity}/{arrivalcity}")
	public List<Flights> sortAllFlightsByRoute(@PathVariable("departurecity") String departureCity,@PathVariable("arrivalcity") String arrivalCity ){
		
		logger.info("Sorted List of flights by given route returned");
		return flightsService.sortAllFlightsByRoute(departureCity, arrivalCity);
	}
	
	@GetMapping("/getallflights")
	public List<Flights> getAllFlights(){
		
		logger.info("All flights returned");
		return flightsService.getAllFlights();
	}


}
