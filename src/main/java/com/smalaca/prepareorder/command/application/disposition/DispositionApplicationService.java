package com.smalaca.prepareorder.command.application.disposition;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.prepareorder.command.domain.disposition.Disposition;
import com.smalaca.prepareorder.command.domain.disposition.DispositionRepository;
import com.smalaca.prepareorder.command.domain.payment.PaymentEvent;
import com.smalaca.prepareorder.command.domain.payment.PaymentEventPublisherIf;
import com.smalaca.prepareorder.command.domain.product.ProductVO;
import com.smalaca.prepareorder.command.domain.productmanagement.ProductManagementResult;
import com.smalaca.prepareorder.command.domain.productmanagement.ProductManagementServiceIf;
import com.smalaca.prepareorder.command.domain.shopping.Shopping;
import com.smalaca.prepareorder.command.domain.shopping.ShoppingRepository;

import java.util.Map;
import java.util.UUID;


@PrimaryAdapter
public class DispositionApplicationService {

    private final DispositionRepository dispositionRepository;
    private final ShoppingRepository shoppingRepository;
    private final ProductManagementServiceIf productManagementService;

    private final PaymentEventPublisherIf paymentEventPublisher;


    public DispositionApplicationService(DispositionRepository dispositionRepository, ShoppingRepository shoppingRepository, ProductManagementServiceIf productManagementService, PaymentEventPublisherIf paymentEventPublisherIf) {
        this.dispositionRepository = dispositionRepository;
        this.shoppingRepository = shoppingRepository;
        this.productManagementService = productManagementService;
        this.paymentEventPublisher = paymentEventPublisherIf;
    }

    public UUID confirmProducts(DispositionCommand dispositionCommand) {

        Shopping shopping = shoppingRepository.findById(dispositionCommand.shoppingId());

        AddressVO addressVO = new AddressVO(dispositionCommand.street(), dispositionCommand.city(), dispositionCommand.houseNumber());

        Disposition disposition = shopping.confirmProducts(dispositionCommand.transportType(), addressVO, dispositionCommand.paymentType(), productManagementService, paymentEventPublisher);

        if (disposition != null) {
            return disposition.getID();
        } else
            return null;
    }


}
