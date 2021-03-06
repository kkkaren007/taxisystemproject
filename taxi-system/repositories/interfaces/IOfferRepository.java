package com.company.repositories.interfaces;

import com.company.entities.Offers;

public interface IOfferRepository {
    boolean addOffer(Offers offer);

    Offers getOfferId();
    Offers getOffer(int orderId);

    int updateOfferAddressFrom(Offers offer);
    int updateOfferAddressTo(Offers offer);

    int deleteOffer(Offers offer);
}
