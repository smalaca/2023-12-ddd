package com.smalaca.orderpreparation.infrastructure.repository.offer;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.orderpreparation.command.domain.offer.Offer;
import com.smalaca.orderpreparation.command.domain.offer.OfferRepository;

import java.util.UUID;

@SecondaryAdapter
public class SpringDataOfferRepository implements OfferRepository {
    @Override
    public UUID save(Offer offer) {
        return null;
    }
}
