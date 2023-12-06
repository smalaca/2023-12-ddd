package com.smalaca.orderpreparation.command.domain.offer;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface OfferRepository {
    UUID save(Offer offer);
}
