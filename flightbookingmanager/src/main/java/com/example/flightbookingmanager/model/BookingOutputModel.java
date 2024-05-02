package com.example.flightbookingmanager.model;

import java.time.LocalDate;
import java.time.LocalTime;

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

public class BookingOutputModel {

	private int id;
	private PassengerOutputModel passengerOutputModel;
	private int totalPassengers;
	private FlightOutputModel flightOutputModel;
	private int totalPrice;

	
	

}
