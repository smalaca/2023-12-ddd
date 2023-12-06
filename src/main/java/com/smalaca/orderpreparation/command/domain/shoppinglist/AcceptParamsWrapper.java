package com.smalaca.orderpreparation.command.domain.shoppinglist;

import java.util.function.Function;

import com.smalaca.orderpreparation.command.application.order.AcceptProductsCommand;
import com.smalaca.orderpreparation.command.domain.order.OrderId;
import com.smalaca.orderpreparation.command.domain.order.OrderNumber;
import com.smalaca.orderpreparation.command.domain.products.ProductsAvailabilityValidator;
import com.smalaca.orderpreparation.command.domain.products.ProductsReservationService;
import com.smalaca.sharedkernel.CustomerId;
import com.smalaca.sharedkernel.domain.eventbus.EventBus;
import com.smalaca.sharedkernel.domain.time.TimeProvider;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AcceptParamsWrapper {
    final OrderId orderId;
    final AcceptProductsCommand.AcceptParams params;
    final CustomerId customer;

    final TimeProvider timeProvider;
    final EventBus eventBus;
    final Function<CustomerId, OrderNumber> randomNumberGenerator;
    final ProductsReservationService productsReservationService;
    final ProductsAvailabilityValidator productsAvailabilityValidator;
}
