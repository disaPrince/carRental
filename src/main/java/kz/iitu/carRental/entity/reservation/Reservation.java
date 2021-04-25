package kz.iitu.carRental.entity.reservation;

import kz.iitu.carRental.entity.cars.Car;
import kz.iitu.carRental.entity.users.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@Component
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateIssue;
    private Integer numberDays;


    @OneToOne
    @JoinColumn(name = "carId", insertable = false, updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;


}
