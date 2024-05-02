package com.example.flightbookingmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.PassengersRepository;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.exception.PassengerNotFoundException;
import com.example.flightbookingmanager.service.PassengerService;

import jakarta.transaction.Transactional;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengersRepository passengersRepository;
	
	//for administrator
	@Transactional
	@Override
	public Passengers addPassengers(Passengers passengers) {
		return passengersRepository.save(passengers);
	}
	
	@Transactional
	@Override
	public List<Passengers> getAllPassengers(){
		return passengersRepository.findAll();
	}
	
	//for user operation
	@Transactional
	@Override
	public Passengers getPassengersById(Integer id) throws PassengerNotFoundException {
		Passengers passengers = passengersRepository.findById(id).orElse(null);
		if(passengers!=null) {
			return passengers;
		}
		throw new PassengerNotFoundException("Passenger does not Exist");
	}
	
	@Transactional
	@Override
	public void deletePassengerById(Integer id) throws PassengerNotFoundException {
		passengersRepository.deleteById(id);
		throw new PassengerNotFoundException("Passenger does not Exist");
	}
	
	@Transactional
	@Override
	public Passengers passengerLogin(Integer id, String password) throws PassengerNotFoundException {
		Passengers passengers = passengersRepository.passengerLogin(id, password);
		if(passengers!=null) {
			return(passengers);
		}
		throw new PassengerNotFoundException("Wrong ID/Password or Passenger does not Exist");
	}
	
	@Transactional
	@Override
	public Passengers updatePassenger(Integer id, String newpassword) {
		Passengers passengers = passengersRepository.updatePassenger(id, newpassword);
		return passengers;
	}
	
	@Transactional
	@Override
	public Passengers getId(String emailId, String password) {
		Passengers passengers = passengersRepository.getId(emailId, password);
		return passengers;
	}

}
