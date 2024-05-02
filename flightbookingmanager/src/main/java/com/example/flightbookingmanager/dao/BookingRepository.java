package com.example.flightbookingmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.flightbookingmanager.entity.Bookings;
import com.example.flightbookingmanager.entity.Passengers;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {
	
	@Query(value="select b from Bookings b where b.id=?1")
	public Bookings getBookingById(Integer Id);
	
	@Query(value="select b from Bookings b")
	public List<Bookings> getAllBookings();
	
	@Query(value="select b from Bookings b where b.id=?1")
	public Passengers getPassengersByBookingId(Integer Id);
}