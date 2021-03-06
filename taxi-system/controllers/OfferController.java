package com.company.controllers;

import com.company.entities.Offers;
import com.company.repositories.interfaces.IOfferRepository;

import java.util.Date;

public class OfferController {
    private IOfferRepository repo;

    public OfferController(IOfferRepository repo) {
        this.repo = repo;
    }

    public String addOffer(int tariffId, int client, double driver, double car, double driverStatus, String addressFrom, String addressTo, String orderDate) {
        Offers offer = new Offers(tariffId, client, driver, car, driverStatus, addressFrom, addressTo, orderDate);

        boolean added = repo.addOffer(offer);

        return (added ? "Offer addition was failed" : ("Offer was added successfully\n" + offer.toString()));
    }

    public String getOffer(int orderId) {
        Offers offer = repo.getOffer(orderId);

        return (offer == null ? "Offer was not found" : offer.toString());
    }

    public String updateOfferAddressFrom(int orderId, String addressFrom) {
        Offers offer = new Offers(orderId, addressFrom);

        int updated = repo.updateOfferAddressFrom(offer);

        return ((updated == 0) ? "Updating of Offer was failed" : ("Offer was updated successfully\n" + offer.toString()));
    }

    public String updateOfferAddressTo(int orderId, String addressTo) {
        Offers offer = new Offers(orderId, addressTo);

        int updated = repo.updateOfferAddressFrom(offer);

        return ((updated == 0) ? "Updating of Offer was failed" : ("Offer was updated successfully\n" + offer.toString()));
    }

    public String deleteOffer(int orderId) {
        Offers offer = new Offers(orderId);

        int orderID = offer.getOrderId();

        int deleted = repo.deleteOffer(offer);

        return ((deleted == 0) ? "Deleting of Offer was failed" : "Offer was deleted successfully");
    }

    public String getOfferId() {
        Offers offer = repo.getOfferId();

        return (offer == null ? "Offer was not found" : ( "Your trip ID " + repo.getOfferId()));
    }
}
