package com.example.flightbookingmanager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.service.FlightsService;
//import com.example.flightbookingmanager.service.PassengerService;

@SpringBootApplication
public class FlightbookingmanagerApplication {

	public static void main(String[] args) {
		ApplicationContext app=
		SpringApplication.run(FlightbookingmanagerApplication.class, args);
		//PassengerService passengerService = app.getBean(PassengerService.class);
		
//		Passengers passengers = new Passengers();
		
//		FlightsService flightsService = app.getBean(FlightsService.class);
//		Flights flights = new Flights();
//		flights.setDepartureCity("Delhi");
//		LocalDate depdate = LocalDate.of(2023, 6, 14);
//		LocalTime deptime = LocalTime.of(17, 25);
//		flights.setDepartureDate(depdate);
//		flights.setDepartureTime(deptime);
//		flights.setArrivalCity("Mumbai");
//		LocalDate arrdate = LocalDate.of(2023, 6, 15);
//		LocalTime arrtime = LocalTime.of(9, 55);
//		flights.setArrivalDate(arrdate);
//		flights.setArrivalTime(arrtime);
//		flights.setTicketPrice(8441);
//		flights = flightsService.addFlights(flights);
//		System.out.println(flights);
	
		
//		FlightsService flightService = new FlightsService();
//		String place1 = "kolkata";
//		String place2= "Mumbai";
//		List<Flights> flightList= flightService.getAllFlightsByRoute(place1, place2);
		
		
		
	}

}
