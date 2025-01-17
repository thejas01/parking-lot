package com.thejas.parking_lot_system.controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thejas.parking_lot_system.model.Car;
import com.thejas.parking_lot_system.model.ParkingSpot;
import com.thejas.parking_lot_system.service.ParkingLotService;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/parking-lot")
public class ParkingLotController {
    private final ParkingLotService service;

   
  //  @Autowired
    public ParkingLotController(ParkingLotService service) {
        this.service = service;
    }

    @PostMapping("/park")
    public ResponseEntity<ParkingSpot> parkCar(@RequestBody Car car) {
        try {
            ParkingSpot spot = service.parkCar(car);
            return ResponseEntity.ok(spot);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/retrieve/{licensePlate}")
    public ResponseEntity<ParkingSpot> retrieveCar(@PathVariable String licensePlate) {
        try {
            ParkingSpot spot = service.retrieveCar(licensePlate);
            return ResponseEntity.ok(spot);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status")
    public ResponseEntity<List<ParkingSpot>> getParkingStatus() {
        return ResponseEntity.ok(service.getParkingStatus());
    }
}
