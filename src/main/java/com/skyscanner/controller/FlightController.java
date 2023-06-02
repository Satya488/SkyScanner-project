package com.skyscanner.controller;

import com.skyscanner.payload.FlightDTO;
import com.skyscanner.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    //http://localhost:8080/api/flights
    @PostMapping
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO) {
        FlightDTO flightDto = flightService.addFlight(flightDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightDto);
    }
   //http://localhost:8080/api/flights/search?leavingFrom=BLR&goingTo=DEL&departureDate=2024-02-10&arrivalDate=2024-02-11
    @GetMapping("/search")
    public ResponseEntity<List<FlightDTO>> searchFlights(
            @RequestParam(required = false) String leavingFrom,
            @RequestParam(required = false) String goingTo,
            @RequestParam(required = false) String departureDate,
            @RequestParam(required = false) String arrivalDate) {

        List<FlightDTO> flightDTOS = flightService.searchFlights(leavingFrom, goingTo, departureDate, arrivalDate);
        return new ResponseEntity<>(flightDTOS,HttpStatus.OK);
    }
}

