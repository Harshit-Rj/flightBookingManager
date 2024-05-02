package com.example.flightbookingmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.PassengersRepository;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.exception.PassengerNotFoundException;

import jakarta.transaction.Transactional;

@Service
public interface PassengerService {
	
	public Passengers addPassengers(Passengers passengers);
	
	public List<Passengers> getAllPassengers();
	
	public Passengers getPassengersById(Integer id) throws PassengerNotFoundException;
	
	public void deletePassengerById(Integer id) throws PassengerNotFoundException;
	
	public Passengers passengerLogin(Integer id, String password) throws PassengerNotFoundException;
	
	public Passengers updatePassenger(Integer id, String newpassword);
	
	public Passengers getId(String emailId, String password);
	
}
