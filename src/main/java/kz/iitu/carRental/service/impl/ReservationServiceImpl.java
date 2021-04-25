package kz.iitu.carRental.service.impl;

import kz.iitu.carRental.entity.reservation.Reservation;
import kz.iitu.carRental.entity.cars.Car;
import kz.iitu.carRental.entity.users.User;
import kz.iitu.carRental.repositories.ReservationRepository;
import kz.iitu.carRental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public String makeReservation(Car car, User user, int numberDay) {
        Reservation reservation = null;
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate= DateFor.format(date);
        reservation.setDateIssue(stringDate);
        reservation.setNumberDays(numberDay);
        reservation.setCar(car);
        reservation.setUser(user);
        reservationRepository.saveAndFlush(reservation);
        return reservation.toString();
    }
}
