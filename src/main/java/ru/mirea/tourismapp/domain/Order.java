package ru.mirea.tourismapp.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String date;
    private String orderName;
    private String airportDeparture;
    private String airportArrive;
    private Long userId;
    private String flightN;
}
