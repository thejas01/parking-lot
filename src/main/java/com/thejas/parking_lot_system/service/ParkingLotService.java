package com.thejas.parking_lot_system.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thejas.parking_lot_system.model.Car;
import com.thejas.parking_lot_system.model.ParkingSpot;
import com.thejas.parking_lot_system.repository.ParkingLotRepository;

@Service
public class ParkingLotService {
    private final ParkingLotRepository repository;

   // @Autowired
    public ParkingLotService(ParkingLotRepository repository) {
        this.repository = repository;
    }

    public ParkingSpot parkCar(Car car) {
        Optional<ParkingSpot> availableSpot = repository.findAvailableSpot();
        if (availableSpot.isPresent()) {
            ParkingSpot spot = availableSpot.get();
            spot.setOccupied(true);
            spot.setCar(car);
            repository.updateSpot(spot);
            return spot;
        } else {
            throw new RuntimeException("Parking lot is full");
        }
    }

    public ParkingSpot retrieveCar(String licensePlate) {
        Optional<ParkingSpot> occupiedSpot = repository.findSpotByCar(licensePlate);
        if (occupiedSpot.isPresent()) {
            ParkingSpot spot = occupiedSpot.get();
            spot.setOccupied(false);
            spot.setCar(null);
            repository.updateSpot(spot);
            return spot;
        } else {
            throw new RuntimeException("Car not found");
        }
    }

    public List<ParkingSpot> getParkingStatus() {
        return repository.getAllSpots();
    }
}