package com.company.repositories.interfaces;

import com.company.entities.Drivers;

public interface IDriverRepository {
    Drivers getDriver(int driverId);
}
