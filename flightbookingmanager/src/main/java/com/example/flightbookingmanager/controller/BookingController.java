package com.example.flightbookingmanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightbookingmanager.entity.Bookings;
import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.exception.BookingNotFoundException;
import com.example.flightbookingmanager.exception.FlightNotFoundException;
import com.example.flightbookingmanager.exception.PassengerNotFoundException;
import com.example.flightbookingmanager.model.BookingInputModel;
import com.example.flightbookingmanager.model.BookingOutputModel;
import com.example.flightbookingmanager.model.FlightOutputModel;
import com.example.flightbookingmanager.model.PassengerOutputModel;
import com.example.flightbookingmanager.service.BookingsService;
import com.example.flightbookingmanager.service.FlightsService;
import com.example.flightbookingmanager.service.PassengerService;

@RestController
public class BookingController {
	
	Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	PassengerService passengerService;
	@Autowired
	BookingsService bookingsService;
	@Autowired
	FlightsService flightService;
	
	@PostMapping("/addbookings")
	public Bookings addBookings(@RequestBody BookingInputModel bookings) throws FlightNotFoundException, PassengerNotFoundException {
		int fid = bookings.getFlightId();
		Flights f = flightService.getFlightsById(fid);
		System.out.println(f);
		Bookings book = new Bookings();
		book.setTotalPassengers(bookings.getTotalPassengers());
		book.setFlights(f);
		book.setTotalPrice(f.getTicketPrice()*bookings.getTotalPassengers());
		
		Passengers p = passengerService.getPassengersById(bookings.getPassengerId());
		book.setPassenger(p);
		
		logger.info("Booking added with ID:"+book.getId());
		return bookingsService.addBookings(book);
	}
	
	@GetMapping("/getallbookings")
	public List<Bookings> getAllBookings(){
		
		logger.info("List of All Bookings returned!!");
		return bookingsService.getAllBookings();
	}
	
	@GetMapping("/getbookingbyid/{id}")
	public ResponseEntity<BookingOutputModel> getBookingById(@PathVariable Integer id) throws BookingNotFoundException {
		Bookings b = bookingsService.getBookingById(id);
		BookingOutputModel bom = new BookingOutputModel();
		
		Passengers p = b.getPassenger();
		PassengerOutputModel pom = new PassengerOutputModel();
		
		FlightOutputModel fom = new FlightOutputModel();
		Flights f = b.getFlights();
		
		pom.setFirstName(p.getFirstName());
		pom.setLastName(p.getLastName());
		pom.setEmail(p.getEmail());
		pom.setId(p.getId());
		pom.setMobileNo(p.getMobileNo());
		
		fom.setArrivalCity(f.getArrivalCity());
		fom.setArrivalDate(f.getArrivalDate());
		fom.setArrivalTime(f.getArrivalTime());
		fom.setDepartureCity(f.getDepartureCity());
		fom.setDepartureDate(f.getDepartureDate());
		fom.setDepartureTime(f.getDepartureTime());
		fom.setId(f.getId());
		fom.setTicketPrice(f.getTicketPrice());
		
		bom.setId(b.getId());
		bom.setTotalPassengers(b.getTotalPassengers());
		bom.setFlightOutputModel(fom);
		bom.setPassengerOutputModel(pom);
		bom.setTotalPrice(b.getTotalPrice());
		
		logger.info("Details of Booking of ID: "+b.getId()+" returned");
		return new ResponseEntity<BookingOutputModel>(bom,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebookingbyid/{id}")
	public void deleteBookingById(@PathVariable Integer id) throws BookingNotFoundException{
		
		bookingsService.deleteBookingbyId(id);
		logger.info("Booking deleted");
	}
	

}
