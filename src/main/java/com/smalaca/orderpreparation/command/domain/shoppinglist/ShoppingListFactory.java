package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.products.ProductsPriceAccessor;
import com.smalaca.orderpreparation.sharedkernel.ChosenProduct;
import com.smalaca.orderpreparation.sharedkernel.Product;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.sharedkernel.domain.eventbus.EventBus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShoppingListFactory {

    private final ShoppingListRepository repository;

    private final ProductsPriceAccessor productsPriceAccessor;

    private final EventBus eventBus;

    @Factory
    private final Function<CustomerId, ShoppingListNumber> randomNumberGenerator =
        customerId -> ShoppingListNumber.of(String.join("-", customerId.getId().toString(), UUID.randomUUID().toString()));

    @Factory
    public ShoppingList create(final CustomerId customer, final List<Product> products) {
        ShoppingListNumber number = randomNumberGenerator.apply(customer);
        List<ChosenProduct> chosenProducts = toChosenProducts(products);
        return ShoppingList.of(repository.generateId(), number, chosenProducts, eventBus);
    }

    private List<ChosenProduct> toChosenProducts(final List<Product> products) {
        return products.stream()
                       .map(product -> ChosenProduct.of(product.getId(), productsPriceAccessor.get(product.getId()), product.getQuantity()))
                       .collect(Collectors.toList());
    }
}
