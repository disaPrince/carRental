package kz.iitu.carRental.service;

import kz.iitu.carRental.entity.cars.Car;

import java.util.List;

public interface CarService {

    String makeNotEmpty(Long id);

    List<Car> showEmptyCars();

    void deleteCar(Long id);

    void addCar(Car car);

    Car findById(Long id);

    void updateCar(Car car);


}
