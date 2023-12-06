package com.smalaca.orderpreparation.command.application.productstoorder;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.orderpreparation.command.domain.offer.Offer;
import com.smalaca.orderpreparation.command.domain.offer.OfferRepository;
import com.smalaca.orderpreparation.command.domain.productstoorder.ProductsToOrder;
import com.smalaca.orderpreparation.command.domain.productstoorder.ProductsToOrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@PrimaryAdapter
public class ProductsToOrderApplicationService {
    private final ProductsToOrderRepository productsToOrderRepository;
    private final OfferRepository offerRepository;

    public ProductsToOrderApplicationService(ProductsToOrderRepository productsToOrderRepository, OfferRepository offerRepository) {
        this.productsToOrderRepository = productsToOrderRepository;
        this.offerRepository = offerRepository;
    }

    @Transactional
    public UUID confirm(ConfirmChoiceCommand command) {
        ProductsToOrder productsToOrder = new ProductsToOrder();

        return productsToOrderRepository.save(productsToOrder);
    }

    @Transactional
    public UUID accept(UUID productsToOrderId) {
        ProductsToOrder productsToOrder = productsToOrderRepository.findById(productsToOrderId);

        Offer offer = productsToOrder.accept();

        return offerRepository.save(offer);
    }
}
