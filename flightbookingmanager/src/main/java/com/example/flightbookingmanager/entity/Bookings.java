package com.example.flightbookingmanager.entity;

import java.time.LocalDate;
import java.util.List;

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
@Table(name="bookings") //optional if table and class names are different , then it is mandatory
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Bookings{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private int totalPassengers;
	private int totalPrice;
	@ManyToOne
	@JoinColumn(name="flights_id", referencedColumnName = "id")
	private Flights flights;
	
	@ManyToOne
	@JoinColumn(name="passenger_id", referencedColumnName = "id")
	private Passengers passenger;

	
	
	//private String flightId; //here
//	private List<Passengers> passengerList;
//	@ManyToOne
//	@JoinColumn(name="passenger_id", referencedColumnName = "id")
//	private Passengers passengers;
	
	
}