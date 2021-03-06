package com.company.controllers;

import com.company.entities.Cars;
import com.company.repositories.interfaces.ICarRepository;

public class CarController {
    private final ICarRepository repo;

    public CarController(ICarRepository repo) {
        this.repo = repo;
    }

    public String getCar(int carId) {
        Cars car = repo.getCar(carId);

        return (car == null ? "Car was not found" : car.toString());
    }
}
