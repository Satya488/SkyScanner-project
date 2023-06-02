package com.skyscanner.service;

import com.skyscanner.entity.Flight;
import com.skyscanner.payload.FlightDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface FlightService {
    FlightDTO addFlight(FlightDTO flightDTO);


    List<FlightDTO> searchFlights(String leavingFrom, String goingTo, String departureDate, String arrivalDate);
}

