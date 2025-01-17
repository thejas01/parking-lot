package com.thejas.parking_lot_system.model;



public class ParkingSpot {
    private int id;
    private boolean occupied;
    private Car car;

    // Default constructor
    public ParkingSpot() {
    }

    // Constructor with parameters
    public ParkingSpot(int id, boolean occupied, Car car) {
        this.id = id;
        this.occupied = occupied;
        this.car = car;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}