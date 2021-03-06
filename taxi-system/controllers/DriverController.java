package com.company.controllers;

import com.company.entities.Drivers;
import com.company.repositories.interfaces.IDriverRepository;

public class DriverController {
    private IDriverRepository repo;

    public DriverController(IDriverRepository repo) {
        this.repo = repo;
    }

    public String getDriver(int driverId) {
        Drivers driver = repo.getDriver(driverId);

        return (driver == null ? "Driver was not found" : driver.toString());
    }
}
