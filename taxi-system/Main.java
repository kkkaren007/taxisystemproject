package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.*;
import com.company.repositories.interfaces.*;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();

        ICarRepository carRepository = new CarRepository(db);
        IClientRepository clientRepository = new ClientRepository(db);
        IDriverRepository driverRepository = new DriverRepository(db);
        IOfferRepository offerRepository = new OfferRepository(db);
        IStatusRepository statusRepository = new StatusRepository(db);
        ITariffRepository tariffRepository = new TariffRepository(db);
        IOfferRepository repo = new OfferRepository(db);

        Application app = new Application(carRepository, clientRepository, driverRepository, offerRepository, statusRepository, tariffRepository, repo);
        app.start();
    }
}
