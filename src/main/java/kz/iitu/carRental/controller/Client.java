package kz.iitu.carRental.controller;

import kz.iitu.carRental.entity.cars.Car;
import kz.iitu.carRental.entity.users.User;
import kz.iitu.carRental.service.ReservationService;
import kz.iitu.carRental.service.CarService;
import kz.iitu.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Client {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/signup")
    public String newUser(@RequestBody User newUser) {
        User newUser1 = userService.getUserbyUsername(newUser.getUsername());
        if (newUser1 != null){
            throw new RuntimeException("With this " + newUser.getUsername() + " is exist");
        }
        if (newUser.getUsername().isEmpty() || newUser.getPassword().isEmpty()){
            throw new RuntimeException("username and password should not be empty");
        }

        userService.newUser(newUser);
        return "Welcome" + newUser.getUsername();
    }

    @GetMapping("/changePassword")
    public String changePass(Long id, String oldPass, String newPass) {
        return userService.changePass(id, oldPass, newPass);
    }

    @GetMapping("/emptyCars")
    public List<Car> emptyCars() {
        return carService.showEmptyCars();
    }

    //making reservation
    @GetMapping("/makeReservation")
    public String makeReservation(Long carId, Long userId, int numberDays) {
        carService.makeNotEmpty(carId);

        Car car = carService.findById(carId);
        User user = userService.findById(userId);

        reservationService.makeReservation(car, user, numberDays);
        return car.toString();
    }


}
