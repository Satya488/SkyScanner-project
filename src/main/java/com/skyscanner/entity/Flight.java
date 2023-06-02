package com.skyscanner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "leaving_from",nullable = false)
    private String leavingFrom;
    @Column(name = "going_to",nullable = false)
    private String goingTo;
    @Column(name = "departure_date",nullable = false)
    private Date departureDate;
    @Column(name = "arrival_date",nullable = false)
    private Date arrivalDate;
    @Column(name = "traveler_type",nullable = false)
    private String travelerType;
    @Column(name = "seats",nullable = false,unique = true)
    private int seats;
    @Column(name = "price",nullable = false)
    private double price;
}