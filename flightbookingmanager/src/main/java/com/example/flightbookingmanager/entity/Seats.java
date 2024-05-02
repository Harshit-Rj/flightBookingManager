package com.example.flightbookingmanager.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="seats") //optional if table and class names are different , then it is mandatory
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Seats{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private boolean status;
	@ManyToOne
	@JoinColumn(name="flight_id", referencedColumnName = "id")
	private Flights flights;
	//private String flightId; //here
	@ManyToOne
	@JoinColumn(name="passengers_id", referencedColumnName = "id")
	private Passengers passengers;
	//private String passengerId;//here
	//private String bookingId;//here 
	@ManyToOne
	@JoinColumn(name="booking_id", referencedColumnName = "id")
	private Bookings bookings;
}