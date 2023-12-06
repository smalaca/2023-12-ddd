package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.orderpreparation.command.domain.offer.Offer;
import com.smalaca.orderpreparation.command.domain.offer.OfferRepository;
import com.smalaca.orderpreparation.command.domain.shopping.Shopping;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@PrimaryAdapter
public class ShoppingApplicationService {
    private final ShoppingRepository shoppingRepository;
    private final OfferRepository offerRepository;

    public ShoppingApplicationService(ShoppingRepository shoppingRepository, OfferRepository offerRepository) {
        this.shoppingRepository = shoppingRepository;
        this.offerRepository = offerRepository;
    }

    @Transactional
    public UUID confirm(ConfirmChoiceCommand command) {
        Shopping shopping = new Shopping();

        return shoppingRepository.save(shopping);
    }

    @Transactional
    public UUID accept(UUID shoppingId) {
        Shopping shopping = shoppingRepository.findById(shoppingId);

        Offer offer = shopping.accept();

        return offerRepository.save(offer);
    }
}
