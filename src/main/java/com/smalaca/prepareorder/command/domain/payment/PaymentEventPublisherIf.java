package com.smalaca.prepareorder.command.domain.payment;

public interface PaymentEventPublisherIf {

    public PublisherResult sendEvent(PaymentEvent paymentEvent);
}
