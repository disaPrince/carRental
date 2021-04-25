package kz.iitu.carRental.repositories;

import kz.iitu.carRental.entity.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
