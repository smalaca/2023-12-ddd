package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;
import com.smalaca.orderpreparation.command.domain.disposal.DisposalRepository;
import com.smalaca.orderpreparation.command.domain.eventpublisher.EventPublisher;
import com.smalaca.orderpreparation.command.domain.productmanagement.ProductManagement;
import com.smalaca.orderpreparation.command.domain.shopping.Shopping;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingFactory;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@PrimaryAdapter
public class ShoppingApplicationService {
    private final ShoppingRepository shoppingRepository;
    private final DisposalRepository disposalRepository;
    private final ShoppingFactory shoppingFactory;
    private final ProductManagement productManagement;
    private final EventPublisher eventPublisher;

    public ShoppingApplicationService(
            ShoppingRepository shoppingRepository, DisposalRepository disposalRepository,
            ShoppingFactory shoppingFactory, ProductManagement productManagement, EventPublisher eventPublisher) {
        this.shoppingRepository = shoppingRepository;
        this.disposalRepository = disposalRepository;
        this.shoppingFactory = shoppingFactory;
        this.productManagement = productManagement;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public UUID confirm(ConfirmChoiceCommand command) {
        Shopping shopping = shoppingFactory.create(command.buyerId(), command.products());

        return shoppingRepository.save(shopping);
    }

    @Transactional
    public UUID accept(AcceptShoppingCommand command) {
        Shopping shopping = shoppingRepository.findById(command.shoppingId());

        Disposal disposal = shopping.accept(command.asAcceptShoppingDomainCommand(productManagement, eventPublisher));

        return disposalRepository.save(disposal);
    }
}
