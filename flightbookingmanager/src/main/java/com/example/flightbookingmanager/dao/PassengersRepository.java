package com.example.flightbookingmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.entity.Passengers;

public interface PassengersRepository extends JpaRepository<Passengers, Integer>{

	@Query(value="select p from Passengers p")
	public List<Passengers> getAllPassengers();
	
	@Query(value="select p from Passengers p where p.id=?1")
	public Flights getPassengersById(Integer id);
	
	@Query(value="select p from Passengers p where p.id=?1 and p.password=?2")
	public Passengers passengerLogin(Integer id, String password);

	//public Passengers passengerLogin(int id, String password);
	
	@Modifying
	@Query(value="UPDATE Passengers p SET p.password =?2 where p.id=?1")
	public Passengers updatePassenger(Integer id, String newpassword);
	
	@Query(value="select p from Passengers p where p.email=?1 and p.password=?2")
	public Passengers getId(String emailId, String password);
}