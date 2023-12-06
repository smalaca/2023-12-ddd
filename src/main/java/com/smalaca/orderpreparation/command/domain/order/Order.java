package com.smalaca.orderpreparation.command.domain.order;

import java.util.List;
import java.util.function.Function;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.shoppinglist.ShoppingListId;
import com.smalaca.orderpreparation.sharedkernel.ChosenProduct;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.validation.ValidatorExecutor;

import jakarta.validation.Valid;
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
    private final OrderId id;

    @NotNull
    private final ShoppingListId shoppingListId;

    @Valid
    @NotNull
    private final OrderNumber number;

    @Valid
    @NotNull
    private final DeliveryInfo deliveryInfo;

    @NotNull
    private final PaymentType paymentType;

    @NotEmpty
    private final List<ChosenProduct> products;

    // todo possible move to separate factory
    @Factory
    public static Order of(final OrderId id, final ShoppingListId shoppingListId, final CustomerId customer,
                           final Function<CustomerId, OrderNumber> randomNumberGenerator,
                           final DeliveryInfo deliveryInfo, final PaymentType paymentType, final List<ChosenProduct> products) {
        Order order = new Order(id, shoppingListId, randomNumberGenerator.apply(customer), deliveryInfo, paymentType, products);
        return ValidatorExecutor.validateAndReturn(order);
    }
}
