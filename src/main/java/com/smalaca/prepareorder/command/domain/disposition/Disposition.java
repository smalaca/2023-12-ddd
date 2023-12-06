package com.smalaca.prepareorder.command.domain.disposition;

import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.prepareorder.command.application.disposition.AddressVO;
import com.smalaca.prepareorder.command.domain.payment.PaymentEvent;
import com.smalaca.prepareorder.command.domain.product.ProductVO;
import com.smalaca.prepareorder.command.domain.productmanagement.ProductManagementResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AggregateRoot
public class Disposition {
    private UUID ID;
    private Map<ProductVO,Integer> listOfProductsWithAmount;
    private String transportType;
    private AddressVO addressVO;
    private String paymentType;

    public Disposition(UUID ID, Map<ProductVO, Integer> listOfProductsWithAmount, String transportType, AddressVO addressVO, String paymentType) {
        this.ID = ID;
        this.listOfProductsWithAmount = listOfProductsWithAmount;
        this.transportType = transportType;
        this.addressVO = addressVO;
        this.paymentType = paymentType;
    }

    public UUID getID() {
        return ID;
    }

    public PaymentEvent createPaymentEvent(){
        List<PaymentEvent.Item> itemsList = new ArrayList<>();
        for (Map.Entry<ProductVO, Integer> entry : listOfProductsWithAmount.entrySet()) {
            ProductVO product = entry.getKey();
            Integer amount = entry.getValue();
            itemsList.add(new PaymentEvent.Item(product.id(),amount,product.price()));

        }
        return new PaymentEvent(itemsList);
    }
}
