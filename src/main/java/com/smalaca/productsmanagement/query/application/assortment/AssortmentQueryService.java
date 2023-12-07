package com.smalaca.productsmanagement.query.application.assortment;

import java.util.UUID;

import com.smalaca.annotation.architecture.PrimaryAdapter;

@PrimaryAdapter
public class AssortmentQueryService {

    public AssortmentDataModel displayAssortment(final UUID assortmentId) {
        return new AssortmentDataModel();
    }

}