package com.smalaca.productmanagement.command.domain.assortment;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.productmanagement.command.domain.productvalidation.ProductDto;
import com.smalaca.productmanagement.command.domain.productvalidation.ProductValidationResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
@Entity
@Table(name = "ASSORTMENT")
//public class Assortment extends AbstractAggregateRoot<Assortment> {
public class Assortment {
    @Id
    @GeneratedValue
    private UUID assortmentId;
    private UUID sellerId;
    private Map<Product, Amount> products = new HashMap<>();

    @PrimaryPort
    public void addProduct(NewProductDomainCommand command) {
        ProductValidationResponse response = verifyProduct(command);

        if (response.isValid()) {
            Product product = new Product(command.name(), command.price(), command.description());
            products.put(product, command.amount());

//            andEvent(ProductAdded.create(assortmentId));
            command.eventPublisher().publish(ProductAdded.create(assortmentId));
        } else {
            command.eventPublisher().publish(InvalidProductRecognized.create(assortmentId, command.name(), command.price()));
        }
    }

    private ProductValidationResponse verifyProduct(NewProductDomainCommand command) {
        return command.productValidation().verify(new ProductDto(command.name(), command.price().value()));
    }
}
