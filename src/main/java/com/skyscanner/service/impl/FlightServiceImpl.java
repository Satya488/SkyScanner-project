package com.skyscanner.service.impl;

import com.skyscanner.entity.Flight;
import com.skyscanner.payload.FlightDTO;
import com.skyscanner.repository.FlightRepository;
import com.skyscanner.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private ModelMapper modelMapper;
    public FlightServiceImpl(FlightRepository flightRepository,ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        Flight flight = mapToEntity(flightDTO);
        Flight saveFlight = flightRepository.save(flight);
        return mapToDTO(saveFlight);
    }

    @Override
    public List<FlightDTO> searchFlights(String leavingFrom, String goingTo, String departureDate, String arrivalDate) {
        // Trim the date and time strings to remove any leading or trailing whitespace
        departureDate = departureDate.trim();
        arrivalDate = arrivalDate.trim();

        // Parse the trimmed strings to LocalDate objects (remove the time component)
        LocalDate departure = LocalDate.parse(departureDate);
        LocalDate arrival = LocalDate.parse(arrivalDate);

        List<Flight> flights = flightRepository.findByLeavingFromAndGoingToAndDepartureDateAndArrivalDate(
                leavingFrom, goingTo, Date.from(departure.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(arrival.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        return mapToDTO(flights);
    }

    private List<FlightDTO> mapToDTO(List<Flight> flights) {
        return flights.stream()
                .map(flight -> modelMapper.map(flight, FlightDTO.class))
                .collect(Collectors.toList());
    }

    private Flight mapToEntity(FlightDTO flightDTO){
      Flight flight = modelMapper.map(flightDTO, Flight.class);
      return flight;
    }
    private FlightDTO mapToDTO(Flight flight){
      FlightDTO flightDTO = modelMapper.map(flight, FlightDTO.class);
      return flightDTO;
    }
}
