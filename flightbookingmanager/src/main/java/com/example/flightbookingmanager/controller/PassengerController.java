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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightbookingmanager.entity.Bookings;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.exception.BookingNotFoundException;
import com.example.flightbookingmanager.exception.PassengerNotFoundException;
import com.example.flightbookingmanager.model.PassengerInputModel;
import com.example.flightbookingmanager.model.PassengerOutputModel;
import com.example.flightbookingmanager.service.BookingsService;
import com.example.flightbookingmanager.service.PassengerService;

@RestController
public class PassengerController {

	Logger logger = LoggerFactory.getLogger(PassengerController.class);
	
	@Autowired
	PassengerService passengerService;
	@Autowired
	BookingsService bookingService;
	
	@PostMapping("/addpassengers")
	public ResponseEntity<Passengers> addPassengers(@RequestBody PassengerInputModel passengers) throws BookingNotFoundException {
		Passengers p = new Passengers();
		p.setId(passengers.getId());
		p.setFirstName(passengers.getFirstName());
		p.setLastName(passengers.getLastName());
		p.setEmail(passengers.getEmail());
		p.setMobileNo(passengers.getMobileNo());
		p.setPassword(passengers.getPassword());
		p = passengerService.addPassengers(p);
		
		logger.info("Passenger Added with ID:" + p.getId());
		return new ResponseEntity<Passengers>(p, HttpStatus.OK);
	}
	
	@PutMapping("/updatepassenger/{id}/{newpassword}")
	public Passengers updatePassenger(@RequestBody Integer id, @RequestBody String newpassword) {
		Passengers passengers = passengerService.updatePassenger(id, newpassword); 
		
		logger.info("Password Upadted for ID"+ passengers.getId());
		return passengers;
		
	}
	@GetMapping("/passengerlogin/{id}/{password}")
	public ResponseEntity<PassengerOutputModel> passengerLogin(@PathVariable Integer id,@PathVariable String password) throws PassengerNotFoundException{
		PassengerOutputModel pom = new PassengerOutputModel();
		Passengers p = passengerService.getPassengersById(id);
		
		pom.setId(p.getId());
		pom.setFirstName(p.getFirstName());
		pom.setLastName(p.getLastName());
		pom.setEmail(p.getEmail());
		pom.setMobileNo(p.getMobileNo());
		
		logger.info("Passenger Logged in with ID:" + p.getId());
		return new ResponseEntity<PassengerOutputModel>(pom,HttpStatus.OK);
	}
	
	@GetMapping("/getallpassengers")
	public List<Passengers> getAllPassengers() {
		
		logger.info("List containing all Passengers returned");
		return passengerService.getAllPassengers();
	}

	@GetMapping("/getpassengersbyid/{id}")
	public ResponseEntity<PassengerOutputModel> getPassengersById(@PathVariable Integer id) throws PassengerNotFoundException {
		
		PassengerOutputModel pom = new PassengerOutputModel();
		Passengers p = passengerService.getPassengersById(id);
		
		pom.setId(p.getId());
		pom.setFirstName(p.getFirstName());
		pom.setLastName(p.getLastName());
		pom.setEmail(p.getEmail());
		pom.setMobileNo(p.getMobileNo());
		
		logger.info("Passenger with given ID" + p.getId() + "returned");
		return new ResponseEntity<PassengerOutputModel>(pom,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletepassengerbyid/{id}")
	public void deletePassengerById(@PathVariable Integer id) throws PassengerNotFoundException {
		passengerService.deletePassengerById(id);
		logger.info("Passenger deleted");
	}
	
	@GetMapping("/getid/{emailid}/{password}")
	public ResponseEntity<PassengerOutputModel> getId(@PathVariable("emailid") String emailId, @PathVariable("password") String password) {

		Passengers p = passengerService.getId(emailId, password);
		PassengerOutputModel pom = new PassengerOutputModel();
		pom.setEmail(p.getEmail());
		pom.setFirstName(p.getFirstName());
		pom.setLastName(p.getLastName());
		pom.setId(p.getId());
		pom.setMobileNo(p.getMobileNo());
		
		logger.info("Returned ID:"+ p.getId());
		return new ResponseEntity<PassengerOutputModel>(pom, HttpStatus.OK);
	}
}
