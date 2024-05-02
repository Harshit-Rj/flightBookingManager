package com.example.flightbookingmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.flightbookingmanager.entity.Flights;
@Repository
public interface FlightsRepository extends JpaRepository<Flights, Integer>{
	
	@Query(value="select f from Flights f where f.id=?1")
	public Flights getFlightsById(Integer id);
	
	@Query(value="select f from Flights f where f.departureCity=?1 and f.arrivalCity=?2")
	public List<Flights> getAllFlightsByRoute(String departureCity, String arrivalCity);
	
	@Query(value="select f from Flights f where f.departureCity=?1 and f.arrivalCity=?2 order by ticketPrice")
	public List<Flights> sortAllFlightsByRoute(String departureCity, String arrivalCity);
	
	@Query(value="select f from Flights f")
	public List<Flights> getAllFlights();
	
	
	
}