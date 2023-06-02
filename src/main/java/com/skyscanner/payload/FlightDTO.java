package com.skyscanner.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class FlightDTO {

    private String leavingFrom;
    private String goingTo;
    private Date departureDate;
    private Date arrivalDate;
    private String travelerType;
    private int seats;
    private double price;


    public FlightDTO(String leavingFrom, String goingTo, Date departureDate, Date arrivalDate, String travelerType, int seats, double price) {
        this.leavingFrom = leavingFrom;
        this.goingTo = goingTo;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.travelerType = travelerType;
        this.seats = seats;
        this.price = price;
    }
}