package com.smalaca.orderpreparation.command.domain.shopping;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.orderpreparation.command.domain.disposal.AcceptShoppingDomainCommand;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;
import com.smalaca.orderpreparation.command.domain.product.Product;
import com.smalaca.orderpreparation.command.domain.productmanagement.BookingResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Shopping {
    private UUID shoppingId;
    private final ShoppingNumber shoppingNumber;
    private final List<Product> products;

    Shopping(ShoppingNumber shoppingNumber, List<Product> products) {
        this.shoppingNumber = shoppingNumber;
        this.products = products;
    }

    @PrimaryPort
    @Factory
    public Disposal accept(AcceptShoppingDomainCommand command) {
        Map<UUID, Integer> productsToBook = new HashMap<>();
        products.forEach(product -> product.addTo(productsToBook));
        BookingResponse response = command.productManagement().book(productsToBook);

        if (response.bookedAll()) {
            return new Disposal(shoppingId, products, command);
        }
    }
}
