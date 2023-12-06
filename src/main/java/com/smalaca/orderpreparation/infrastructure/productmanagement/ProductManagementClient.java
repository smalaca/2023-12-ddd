package com.smalaca.orderpreparation.infrastructure.productmanagement;

import com.smalaca.orderpreparation.command.domain.productmanagement.BookingResponse;
import com.smalaca.orderpreparation.command.domain.productmanagement.ProductManagement;
import com.smalaca.productmanagement.infrastructure.api.booking.BookingApi;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class ProductManagementClient implements ProductManagement {
    private final BookingApi bookingApi;

    public ProductManagementClient(BookingApi bookingApi) {
        this.bookingApi = bookingApi;
    }

    @Override
    public BookingResponse book(Map<UUID, Integer> productsToBook) {
//        Response response = bookingApi.book(asRequestDto(productsToBook));
//        BookingResponse bookingResponse = asBookingResponse(response);
//        return bookingResponse;
        return null;
    }

    @Override
    public Map<UUID, BigDecimal> priceFor(Set<UUID> productIds) {
        return null;
    }
}
