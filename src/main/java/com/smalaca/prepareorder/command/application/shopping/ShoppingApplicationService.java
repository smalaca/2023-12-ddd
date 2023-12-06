package com.smalaca.prepareorder.command.application.shopping;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.prepareorder.command.domain.shopping.ShoppingRepository;

import java.util.UUID;


@PrimaryAdapter
public class ShoppingApplicationService {

    private final ShoppingRepository shoppingRepository;


    public ShoppingApplicationService(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }


    public UUID confirmChose(ShoppingCommand shoppingCommand) {
    }
}
