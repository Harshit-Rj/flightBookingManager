package com.example.flightbookingmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.BookingRepository;
import com.example.flightbookingmanager.entity.Bookings;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.exception.BookingNotFoundException;
import com.example.flightbookingmanager.exception.PassengerNotFoundException;

import jakarta.transaction.Transactional;

@Service
public interface BookingsService {

	public Bookings addBookings(Bookings book);
	
	public List<Bookings> getAllBookings();
	
	public Bookings getBookingById(Integer id) throws BookingNotFoundException;
	
	public void deleteBookingbyId(Integer id) throws BookingNotFoundException;
}
	
	
