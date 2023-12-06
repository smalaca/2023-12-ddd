package com.smalaca.prepareorder.infrastructure.rest;


import com.smalaca.prepareorder.command.application.disposition.ConfirmationOfProductsCommand;
import com.smalaca.prepareorder.command.application.disposition.DispositionApplicationService;
import com.smalaca.prepareorder.query.PrepareOrderQueryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PrepareOrderRestController {

    private final DispositionApplicationService dispositionApplicationService;
    private final PrepareOrderQueryService prepareOrderQueryService;

    public PrepareOrderRestController(DispositionApplicationService dispositionApplicationService, PrepareOrderQueryService prepareOrderQueryService) {
        this.dispositionApplicationService = dispositionApplicationService;
        this.prepareOrderQueryService = prepareOrderQueryService;
    }
    @PostMapping
    public UUID confirmationOfProducts(ConfirmationOfProductsCommand confirmationOfProductsCommand){
        return dispositionApplicationService.confirmProducts(confirmationOfProductsCommand);
    }

}
