package com.company.controllers;

import com.company.entities.Tariff;
import com.company.repositories.interfaces.ITariffRepository;

import java.util.List;

public class TariffController {
    private ITariffRepository repo;

    public TariffController(ITariffRepository repo) {
        this.repo = repo;
    }

    public String getTariff(int tariffId) {
        Tariff tariff = repo.getTariff(tariffId);

        return (tariff == null ? "Tariff was not found" : tariff.toString());
    }

    public String getAllTariff() {
        List<Tariff> tariffs = repo.getAllTariff();

        return tariffs.toString();
    }
}
