package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;
import java.util.UUID;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.shoppinglist.Product;
import com.smalaca.validation.ValidatorExecutor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AggregateRoot
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @Getter
    @NotNull
    private final UUID id;

    @NotNull
    private final UUID shoppingListId;

    @NotBlank
    private final String number;

    @NotNull
    private final Address address;

    @NotNull
    private final DeliveryType deliveryType;

    @NotNull
    private final PaymentType paymentType;

    @NotEmpty
    private final List<Product> products;

    @Factory
    public static Order of(final UUID id, final UUID shoppingListId, final UUID customer, // todo fixme 3 same args
                           final Address address, final DeliveryType deliveryType, final PaymentType paymentType, final List<Product> products) {
        return ValidatorExecutor.validateAndReturn(new Order(id, shoppingListId, customer + UUID.randomUUID().toString(), address, deliveryType,
                                                             paymentType, products));
    }
}
