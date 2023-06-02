package com.skyscanner.repository;

import com.skyscanner.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    List<Flight> findByLeavingFromAndGoingToAndDepartureDateAndArrivalDate(String leavingFrom, String goingTo, Date departure, Date arrival);
}

