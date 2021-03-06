package com.company.repositories.interfaces;

import com.company.entities.Tariff;

import java.util.List;

public interface ITariffRepository {
    Tariff getTariff(int tariffId);

    List<Tariff> getAllTariff();
}
