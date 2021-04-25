package kz.iitu.carRental.controller;

import kz.iitu.carRental.entity.cars.Car;
import kz.iitu.carRental.entity.users.User;
import kz.iitu.carRental.service.ReservationService;
import kz.iitu.carRental.service.CarService;
import kz.iitu.carRental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class Admin {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        System.out.println("UserController.createUser");
        System.out.println("user = " + user);

        userService.createUser(user);
    }


    @GetMapping("/create")
    public void createUserByUsernameAndPassword(String username,
                                                String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.createUser(user);
    }

    @GetMapping("/userslist")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/updateCar")
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
    }

    @GetMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }

    @PostMapping("/addCar")
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }




}
