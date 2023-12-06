package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;
import com.smalaca.orderpreparation.command.domain.disposal.DisposalRepository;
import com.smalaca.orderpreparation.command.domain.product.Product;
import com.smalaca.orderpreparation.command.domain.shopping.Shopping;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@PrimaryAdapter
public class ShoppingApplicationService {
    private final ShoppingRepository shoppingRepository;
    private final DisposalRepository disposalRepository;

    public ShoppingApplicationService(ShoppingRepository shoppingRepository, DisposalRepository disposalRepository) {
        this.shoppingRepository = shoppingRepository;
        this.disposalRepository = disposalRepository;
    }

    @Transactional
    public UUID confirm(ConfirmChoiceCommand command) {
        List<Product> products = command.asProducts();

        Shopping shopping = new Shopping(products);

        return shoppingRepository.save(shopping);
    }

    @Transactional
    public UUID accept(AcceptShoppingCommand command) {
        Shopping shopping = shoppingRepository.findById(command.shoppingId());

        Disposal disposal = shopping.accept(command.asAcceptShoppingDomainCommand());

        return disposalRepository.save(disposal);
    }
}
