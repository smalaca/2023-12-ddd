package com.smalaca.prepareorder.infrastructure.rest;


import com.smalaca.prepareorder.command.application.disposition.ConfirmationOfProductsCommand;
import com.smalaca.prepareorder.command.application.disposition.PrepareOrderApplicationService;
import com.smalaca.prepareorder.query.PrepareOrderQueryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PrepareOrderRestController {

    private final PrepareOrderApplicationService prepareOrderApplicationService;
    private final PrepareOrderQueryService prepareOrderQueryService;

    public PrepareOrderRestController(PrepareOrderApplicationService prepareOrderApplicationService, PrepareOrderQueryService prepareOrderQueryService) {
        this.prepareOrderApplicationService = prepareOrderApplicationService;
        this.prepareOrderQueryService = prepareOrderQueryService;
    }
    @PostMapping
    public UUID confirmationOfProducts(ConfirmationOfProductsCommand confirmationOfProductsCommand){
        return prepareOrderApplicationService.confirmProducts(confirmationOfProductsCommand);
    }

}
