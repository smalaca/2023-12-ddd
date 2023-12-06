package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.sharedcernel.Product;
import com.smalaca.sharedcernel.CustomerId;
import com.smalaca.validation.ValidatorExecutor;

import jakarta.validation.Valid;
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

    @Valid
    @NotNull
    private final DeliveryInfo deliveryInfo;

    @NotNull
    private final PaymentType paymentType;

    @NotEmpty
    private final List<Product> products;

    // todo possible move to separate factory
    @Factory
    public static Order of(final UUID id, final UUID shoppingListId, final CustomerId customer,
                           final Function<CustomerId, String> randomNumberGenerator,
                           final DeliveryInfo deliveryInfo, final PaymentType paymentType, final List<Product> products) {
        Order order = new Order(id, shoppingListId, randomNumberGenerator.apply(customer), deliveryInfo, paymentType, products);
        return ValidatorExecutor.validateAndReturn(order);
    }
}
