package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.products.ProductsPriceAccessor;
import com.smalaca.orderpreparation.sharedkernel.ChosenProduct;
import com.smalaca.orderpreparation.sharedkernel.Product;
import com.smalaca.productsmanagement.command.domain.assortment.Price;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.sharedkernel.domain.eventbus.EventBus;
import com.smalaca.sharedkernel.domain.time.TimeProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShoppingListFactory {

    private final ShoppingListRepository repository;

    private final ProductsPriceAccessor productsPriceAccessor;

    private final EventBus eventBus;

    private final TimeProvider timeProvider;

    @Factory
    private final Function<CustomerId, ShoppingListNumber> randomNumberGenerator =
        customerId -> ShoppingListNumber.of(String.join("-", customerId.getId().toString(), UUID.randomUUID().toString()));

    @Factory
    public ShoppingList create(final CustomerId customer, final List<Product> products) {
        ShoppingListNumber number = randomNumberGenerator.apply(customer);
        List<ChosenProduct> chosenProducts = toChosenProducts(products);
        return ShoppingList.of(repository.generateId(), number, chosenProducts, timeProvider, eventBus);
    }

    private List<ChosenProduct> toChosenProducts(final List<Product> products) {
        return products.stream().map(this::toProduct).collect(Collectors.toList());
    }

    private ChosenProduct toProduct(final Product product) {
        Price price = productsPriceAccessor.get(product.getId());
        return ChosenProduct.of(product.getId(), price, product.getQuantity());
    }

}
