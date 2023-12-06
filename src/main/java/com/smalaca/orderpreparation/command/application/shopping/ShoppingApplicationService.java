package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;
import com.smalaca.orderpreparation.command.domain.disposal.DisposalRepository;
import com.smalaca.orderpreparation.command.domain.product.Product;
import com.smalaca.orderpreparation.command.domain.productmanagement.ProductManagement;
import com.smalaca.orderpreparation.command.domain.shopping.Shopping;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingFactory;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@PrimaryAdapter
public class ShoppingApplicationService {
    private final ShoppingRepository shoppingRepository;
    private final DisposalRepository disposalRepository;
    private final ShoppingFactory shoppingFactory;
    private final ProductManagement productManagement;

    public ShoppingApplicationService(
            ShoppingRepository shoppingRepository, DisposalRepository disposalRepository,
            ShoppingFactory shoppingFactory, ProductManagement productManagement) {
        this.shoppingRepository = shoppingRepository;
        this.disposalRepository = disposalRepository;
        this.shoppingFactory = shoppingFactory;
        this.productManagement = productManagement;
    }

    @Transactional
    public UUID confirm(ConfirmChoiceCommand command) {
        List<Product> products = command.asProducts();

        Shopping shopping = shoppingFactory.create(command.buyerId(), products);

        return shoppingRepository.save(shopping);
    }

    @Transactional
    public UUID accept(AcceptShoppingCommand command) {
        Shopping shopping = shoppingRepository.findById(command.shoppingId());

        Disposal disposal = shopping.accept(command.asAcceptShoppingDomainCommand(productManagement));

        return disposalRepository.save(disposal);
    }
}
