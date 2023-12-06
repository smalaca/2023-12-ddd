package com.smalaca.prepareorder.infrastructure.rest;


import com.smalaca.prepareorder.command.application.disposition.DispositionCommand;
import com.smalaca.prepareorder.command.application.disposition.DispositionApplicationService;
import com.smalaca.prepareorder.command.application.shopping.ShoppingApplicationService;
import com.smalaca.prepareorder.command.application.shopping.ShoppingCommand;
import com.smalaca.prepareorder.query.PrepareOrderQueryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PrepareOrderRestController {

    private final DispositionApplicationService dispositionApplicationService;
    private final ShoppingApplicationService shoppingApplicationService;
    private final PrepareOrderQueryService prepareOrderQueryService;

    public PrepareOrderRestController(DispositionApplicationService dispositionApplicationService, ShoppingApplicationService shoppingApplicationService, PrepareOrderQueryService prepareOrderQueryService) {
        this.dispositionApplicationService = dispositionApplicationService;
        this.shoppingApplicationService = shoppingApplicationService;
        this.prepareOrderQueryService = prepareOrderQueryService;
    }
    @PostMapping
    public UUID confirmProducts(DispositionCommand dispositionCommand){
        return dispositionApplicationService.confirmProducts(dispositionCommand);
    }

    @PostMapping
    public UUID confirmChose(ShoppingCommand shoppingCommand){
        return shoppingApplicationService.confirmChose(shoppingCommand);
    }


}
