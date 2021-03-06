package com.company.repositories.interfaces;

import com.company.entities.Status;

public interface IStatusRepository {
    Status getStatus(int statusNumber);
}
