package com.smalaca.prepareorder.command.domain.shopping;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.prepareorder.command.application.disposition.AddressVO;
import com.smalaca.prepareorder.command.domain.disposition.Disposition;
import com.smalaca.prepareorder.command.domain.payment.PaymentEvent;
import com.smalaca.prepareorder.command.domain.payment.PaymentEventPublisherIf;
import com.smalaca.prepareorder.command.domain.product.ProductVO;
import com.smalaca.prepareorder.command.domain.productmanagement.ProductManagementResult;
import com.smalaca.prepareorder.command.domain.productmanagement.ProductManagementServiceIf;

import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Shopping {

    private UUID ID;
    private Map<ProductVO, Integer> listOfProductsWithAmount;

    public Shopping(UUID buyerID) {
        this.ID = UUID.fromString(buyerID.toString());
    }

    @PrimaryPort
    @Factory
    public Disposition confirmProducts(String transportType, AddressVO addressVO, String paymentType, ProductManagementServiceIf productManagementService, PaymentEventPublisherIf paymentEventPublisher) {
        for (Map.Entry<ProductVO, Integer> entry : listOfProductsWithAmount.entrySet()) {
            ProductVO product = entry.getKey();
            Integer amount = entry.getValue();
            ProductManagementResult productManagementResult = productManagementService.reserveProduct(product.id(), amount);
            if (!productManagementResult.isValid()) {
                return null;
            }
        }
        Disposition disposition = new Disposition(UUID.randomUUID(), listOfProductsWithAmount, transportType, addressVO, paymentType);
        PaymentEvent paymentEvent = disposition.createPaymentEvent();
        paymentEventPublisher.sendEvent(paymentEvent);
        return disposition;
    }

    public UUID getID() {
        return ID;
    }
}
