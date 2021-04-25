package kz.iitu.carRental.service.impl;

import kz.iitu.carRental.entity.cars.Car;
import kz.iitu.carRental.repositories.CarRepository;
import kz.iitu.carRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).get();
        carRepository.delete(car);
    }

    @Override
    public void addCar(Car car) {
        carRepository.saveAndFlush(car);
    }

    @Override
    public Car findById(Long id) {
        Car car = carRepository.findById(id).get();
        return car;
    }

    @Override
    public void updateCar(Car car) {
        carRepository.saveAndFlush(car);
    }

    @Override
    public String makeNotEmpty(Long id) {
        Car car = carRepository.findById(id).get();
        if (car.isEmpty()) {
            car.setEmpty(false);
        } else {
            car.setEmpty(true);
        }
        return null;
    }

    @Override
    public List<Car> showEmptyCars() {
        return carRepository.findAll();
    }
}
