package com.smalaca.orderpreparation.command.application.shopping;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;
import com.smalaca.orderpreparation.command.domain.disposal.DisposalRepository;
import com.smalaca.orderpreparation.command.domain.shopping.Shopping;
import com.smalaca.orderpreparation.command.domain.shopping.ShoppingRepository;
import org.springframework.transaction.annotation.Transactional;

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
        Shopping shopping = new Shopping();

        return shoppingRepository.save(shopping);
    }

    @Transactional
    public UUID accept(UUID shoppingId) {
        Shopping shopping = shoppingRepository.findById(shoppingId);

        Disposal disposal = shopping.accept();

        return disposalRepository.save(disposal);
    }
}
