package kz.iitu.carRental.repositories;

import kz.iitu.carRental.entity.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
