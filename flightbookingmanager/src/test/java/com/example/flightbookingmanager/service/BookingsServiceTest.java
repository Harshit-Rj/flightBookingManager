package com.example.flightbookingmanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.flightbookingmanager.dao.BookingRepository;
import com.example.flightbookingmanager.dao.FlightsRepository;
import com.example.flightbookingmanager.entity.Bookings;
import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.entity.Passengers;
import com.example.flightbookingmanager.exception.BookingNotFoundException;
import com.example.flightbookingmanager.service.impl.BookingsServiceImpl;


public class BookingsServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingsServiceImpl bookingsService;

    private List<Bookings> bookingsList;

    @BeforeEach
    public void setUp() {
        Flights flights = new Flights();
        flights.setId(1);
        flights.setDepartureCity("city1");
        flights.setDepartureDate(LocalDate.now());
        flights.setDepartureTime(LocalTime.now());
        flights.setArrivalCity("city2");
        flights.setArrivalDate(LocalDate.now().plusDays(1));
        flights.setArrivalTime(LocalTime.now().plusHours(1));
        flights.setTicketPrice(10000);
        
        Passengers p = new Passengers();
        p.setId(1);
        p.setEmail("passenger1@gmail.com");
        p.setFirstName("fname1");
        p.setLastName("lname1");
        p.setMobileNo("123456789");
        p.setPassword("password1");
        
        
        bookingsList = new ArrayList<>();
        Bookings booking1 = new Bookings();
        booking1.setId(1);
        booking1.setFlights(flights);
        booking1.setPassenger(p);
        bookingsList.add(booking1);

        Flights flights2 = new Flights();
        flights2.setId(2);
        flights2.setDepartureCity("city2");
        flights2.setDepartureDate(LocalDate.now());
        flights2.setDepartureTime(LocalTime.now());
        flights2.setArrivalCity("city3");
        flights2.setArrivalDate(LocalDate.now().plusDays(1));
        flights2.setArrivalTime(LocalTime.now().plusHours(1));
        flights2.setTicketPrice(10000);
        
        Passengers p2 = new Passengers();
        p2.setId(2);
        p2.setEmail("passenger2@gmail.com");
        p2.setFirstName("fname2");
        p2.setLastName("lname2");
        p2.setMobileNo("123456780");
        p2.setPassword("password2");
        
        Bookings booking2 = new Bookings();
        booking2.setId(2);
        booking2.setFlights(flights2);
        booking2.setPassenger(p2);
        bookingsList.add(booking2);
    }

    @Test
    public void testAddBookings() {
    	
    	Flights flights = new Flights();
        flights.setId(3);
        flights.setDepartureCity("city1");
        flights.setDepartureDate(LocalDate.now());
        flights.setDepartureTime(LocalTime.now());
        flights.setArrivalCity("city2");
        flights.setArrivalDate(LocalDate.now().plusDays(1));
        flights.setArrivalTime(LocalTime.now().plusHours(1));
        flights.setTicketPrice(10000);
        
        Passengers p = new Passengers();
        p.setId(3);
        p.setEmail("passenger1@gmail.com");
        p.setFirstName("fname1");
        p.setLastName("lname1");
        p.setMobileNo("123456789");
        p.setPassword("password1");
    	
        Bookings booking = new Bookings();
        booking.setId(3);
        booking.setFlights(flights);
        booking.setPassenger(p);

       
    }

    @Test
    public void testGetAllBookings() {
    	
    	
        when(bookingRepository.findAll()).thenReturn(bookingsList);

        List<Bookings> allBookings = bookingsService.getAllBookings();

        assertEquals(bookingsList, allBookings);
    }

    @Test
    public void testGetBookingById() throws BookingNotFoundException {
        int id = 1;
        Bookings booking = bookingsList.get(0);

        when(bookingRepository.findById(id)).thenReturn(Optional.of(booking));

        Bookings foundBooking = bookingsService.getBookingById(id);

        assertNotNull(foundBooking);
        assertEquals(booking, foundBooking);
    }

    @Test
    public void testGetBookingByIdNotFoundException() throws BookingNotFoundException {
        int id = 100;

        //when(bookingRepository.findById(id)).thenReturn(Optional.empty());

        bookingsService.getBookingById(id);
    }

    @Test
    public void testDeleteBookingById() throws BookingNotFoundException {
        int id = 1;
        Bookings booking = bookingsList.get(0);

        when(bookingRepository.findById(id)).thenReturn(Optional.of(booking));

        bookingsService.deleteBookingbyId(id);

        assertNull(bookingsList.get(0));
    }

    @Test
    public void testDeleteBookingByIdNotFoundException() throws BookingNotFoundException {
        int id = 5;

        when(bookingRepository.findById(id)).thenReturn(Optional.empty());

        bookingsService.deleteBookingbyId(id);
    }
}