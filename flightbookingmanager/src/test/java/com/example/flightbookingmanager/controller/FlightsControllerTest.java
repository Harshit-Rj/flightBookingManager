package com.example.flightbookingmanager.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.flightbookingmanager.entity.Flights;
import com.example.flightbookingmanager.exception.FlightNotFoundException;
import com.example.flightbookingmanager.model.FlightInputModel;
import com.example.flightbookingmanager.service.FlightsService;
import com.example.flightbookingmanager.service.impl.FlightsServiceImpl;


@SpringBootTest
public class FlightsControllerTest {

	@Mock
    private FlightsServiceImpl flightsService;

	@InjectMocks
    private FlightsController flightsController;

    private List<Flights> flightsList;

    @BeforeEach
    public void setUp() {
        flightsController = new FlightsController();
        flightsController.flightsService = flightsService;

        flightsList = new ArrayList<>();
        Flights flight1 = new Flights();
        flight1.setId(1);
        flight1.setDepartureCity("New York");
        flight1.setDepartureDate(LocalDate.now());
        flight1.setDepartureTime(LocalTime.now());
        flight1.setArrivalCity("London");
        flight1.setArrivalDate(LocalDate.now().plusDays(1));
        flight1.setArrivalTime(LocalTime.now().plusHours(1));
        flightsList.add(flight1);

        Flights flight2 = new Flights();
        flight2.setId(2);
        flight2.setDepartureCity("London");
        flight2.setDepartureDate(LocalDate.now());
        flight2.setDepartureTime(LocalTime.now());
        flight2.setArrivalCity("New York");
        flight2.setArrivalDate(LocalDate.now().plusDays(1));
        flight2.setArrivalTime(LocalTime.now().plusHours(1));
        flightsList.add(flight2);
    }

    @Test
    public void testAddFlights() {
        FlightInputModel flightInputModel = new FlightInputModel();
        flightInputModel.setId(1);
        flightInputModel.setDepartureCity("New York");
        flightInputModel.setArrivalCity("London");
        flightInputModel.setDepartureDate(LocalDate.now());
        flightInputModel.setDepartureTime(LocalTime.now()); 

        Flights flight = new Flights();
        flight.setId(1);
        flight.setDepartureCity("New York");
        flight.setArrivalCity("London");
        flight.setDepartureDate(LocalDate.now());
        flight.setDepartureTime(LocalTime.now());

        when(flightsService.addFlights(flight)).thenReturn(flight);

        //ResponseEntity<Flights> responseEntity = flightsController.addFlights(flightInputModel);

        //assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertEquals(flight, responseEntity.getBody());
    }

    @Test
    public void testGetFlightsById() throws FlightNotFoundException {
        int id = 1;
        Flights flight = flightsList.get(0);

        when(flightsService.getFlightsById(id)).thenReturn(flight);

        Flights foundFlight = flightsController.getFlightsById(id);

        assertEquals(flight, foundFlight);
    }

    @Test
    
    public void testGetFlightsByIdNotFoundException() throws FlightNotFoundException {
        int id = 100;

        flightsController.getFlightsById(id);
    }

    @Test
    public void testGetAllFlightsByRoute() {
        String departureCity = "New York";
        String arrivalCity = "London";

        when(flightsService.getAllFlightsByRoute(departureCity, arrivalCity)).thenReturn(flightsList);

        List<Flights> foundFlightsList = flightsController.getAllFlightsByRoute(departureCity, arrivalCity);

        assertEquals(flightsList, foundFlightsList);
    }

    @Test
    public void testSortAllFlightsByRoute() {
        String departureCity = "London";
        String arrivalCity = "New York";

        when(flightsService.sortAllFlightsByRoute(departureCity, arrivalCity)).thenReturn(flightsList);

        List<Flights> sortedFlightsList = flightsController.sortAllFlightsByRoute(departureCity, arrivalCity);

        assertEquals(flightsList, sortedFlightsList);
    }

    @Test
    public void testGetAllFlights() {
        when(flightsService.getAllFlights()).thenReturn(flightsList);

        List<Flights> allFlights = flightsController.getAllFlights();

        assertEquals(flightsList, allFlights);
    }
}