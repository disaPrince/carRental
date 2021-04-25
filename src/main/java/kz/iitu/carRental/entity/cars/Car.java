package kz.iitu.carRental.entity.cars;

import kz.iitu.carRental.entity.reservation.Reservation;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isEmpty;
    private String model;
    private String color;
    private Double volume;
    private Integer numSeat;
    private Integer numDoors;
    private CarType type;
    private TransmissionType transmissionType;
    private int price;

    @OneToOne(mappedBy = "car", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Reservation reservation;
}
