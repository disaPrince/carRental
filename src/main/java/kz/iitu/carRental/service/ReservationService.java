package kz.iitu.carRental.service;

import kz.iitu.carRental.entity.cars.Car;
import kz.iitu.carRental.entity.users.User;

public interface ReservationService {
    String makeReservation(Car car, User user, int numberDay);
}
