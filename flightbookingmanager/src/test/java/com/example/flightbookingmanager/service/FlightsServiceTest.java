package com.example.flightbookingmanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.flightbookingmanager.dao.FlightsRepository;
import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.exception.FlightNotFoundException;
import com.example.flightbookingmanager.service.impl.FlightsServiceImpl;

public class FlightsServiceTest {

    @Mock
    private FlightsRepository flightsRepository;

    @InjectMocks
    private FlightsServiceImpl flightsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddFlights() {
    	//Prepare Data
        Flights flights = new Flights();
        when(flightsRepository.save(flights)).thenReturn(flights);

        Flights savedFlights = flightsService.addFlights(flights);

        assertEquals(flights, savedFlights);
    }

    @Test
    public void testGetAllFlights() {
        List<Flights> flightsList = new ArrayList<>();
        when(flightsRepository.findAll()).thenReturn(flightsList);

        List<Flights> returnedFlightsList = flightsService.getAllFlights();

        assertEquals(flightsList, returnedFlightsList);
    }

    @Test
    public void testGetFlightsById() throws FlightNotFoundException {
        int id = 1;
        Flights flights = new Flights();
        flights.setId(id);
        Optional<Flights> optionalFlights = Optional.of(flights);
        when(flightsRepository.findById(id)).thenReturn(optionalFlights);

        Flights returnedFlights = flightsService.getFlightsById(id);

        assertEquals(flights, returnedFlights);
    }


    @Test
    public void testGetAllFlightsByRoute() {
        String departureCity = "Kolkata";
        String arrivalCity = "Mumbai";
        List<Flights> flightsList = new ArrayList<>();
        when(flightsRepository.getAllFlightsByRoute(departureCity, arrivalCity)).thenReturn(flightsList);

        List<Flights> returnedFlightsList = flightsService.getAllFlightsByRoute(departureCity, arrivalCity);

        assertEquals(flightsList, returnedFlightsList);
    }

    @Test
    public void testSortAllFlightsByRoute() {
        String departureCity = "Kolkata";
        String arrivalCity = "Mumbai";
        List<Flights> flightsList = new ArrayList<>();
        when(flightsRepository.sortAllFlightsByRoute(departureCity, arrivalCity)).thenReturn(flightsList);

        List<Flights> returnedFlightsList = flightsService.sortAllFlightsByRoute(departureCity, arrivalCity);

        assertEquals(flightsList, returnedFlightsList);
    }
}