package com.example.flightbookingmanager.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class FlightInputModel {

	private int id;
	private String departureCity;
	private LocalDate departureDate;
	private LocalTime departureTime;
	private String arrivalCity;
	private LocalTime arrivalTime;
	private LocalDate arrivalDate;
	private int ticketPrice; 

}
