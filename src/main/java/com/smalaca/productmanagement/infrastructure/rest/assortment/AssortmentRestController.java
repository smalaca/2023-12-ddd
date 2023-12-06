package com.smalaca.productmanagement.infrastructure.rest.assortment;

import com.smalaca.productmanagement.command.application.assortment.AssortmentApplicationService;
import com.smalaca.productmanagement.command.application.assortment.NewProductCommand;
import com.smalaca.productmanagement.query.assortment.AssortmentDataModel;
import com.smalaca.productmanagement.query.assortment.AssortmentQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AssortmentRestController {
    private final AssortmentApplicationService assortmentApplicationService;
    private final AssortmentQueryService assortmentQueryService;

    public AssortmentRestController(AssortmentApplicationService assortmentApplicationService, AssortmentQueryService assortmentQueryService) {
        this.assortmentApplicationService = assortmentApplicationService;
        this.assortmentQueryService = assortmentQueryService;
    }

    @PostMapping
    public UUID addProduct(NewProductCommand command) {
        return assortmentApplicationService.addProduct(command);
    }

    @GetMapping
    public AssortmentDataModel displayAssortment(UUID assortmentId) {
        return assortmentQueryService.displayAssortment(assortmentId);
    }
}
