package com.thejas.parking_lot_system.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.thejas.parking_lot_system.model.ParkingSpot;

@Repository
public class ParkingLotRepository {
    private final Map<Integer, ParkingSpot> parkingSpots = new HashMap<>();

    public ParkingLotRepository() {
        // Initialize 10 parking spots
        for (int i = 1; i <= 10; i++) {
            parkingSpots.put(i, new ParkingSpot(i, false, null));
        }
    }

    public Optional<ParkingSpot> findAvailableSpot() {
        return parkingSpots.values().stream()
                .filter(spot -> !spot.isOccupied())
                .findFirst();
    }

    public Optional<ParkingSpot> findSpotByCar(String licensePlate) {
        return parkingSpots.values().stream()
                .filter(spot -> spot.isOccupied() && spot.getCar().getLicensePlate().equals(licensePlate))
                .findFirst();
    }

    public void updateSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getId(), spot);
    }

    public List<ParkingSpot> getAllSpots() {
        return new ArrayList<>(parkingSpots.values());
    }
}