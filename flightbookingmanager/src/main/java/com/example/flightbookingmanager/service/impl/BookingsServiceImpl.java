package com.example.flightbookingmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.dao.BookingRepository;
import com.example.flightbookingmanager.entity.Bookings;
import com.example.flightbookingmanager.exception.BookingNotFoundException;
import com.example.flightbookingmanager.service.BookingsService;

import jakarta.transaction.Transactional;

@Service
public class BookingsServiceImpl implements BookingsService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Transactional
	@Override
	public Bookings addBookings(Bookings book){
		return bookingRepository.save(book);
	}
	
	@Transactional
	@Override
	public List<Bookings> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	@Transactional
	@Override
	public Bookings getBookingById(Integer id) throws BookingNotFoundException {
		Bookings bookings = bookingRepository.findById(id).orElse(null);
		if(bookings!=null) {
			return bookings;
		}
		throw new BookingNotFoundException("No booking found!!");
	}
	
	@Transactional
	@Override
	public void deleteBookingbyId(Integer id) throws BookingNotFoundException{
		bookingRepository.deleteById(id);
		throw new BookingNotFoundException("No booking found!!");
	}
	

}
