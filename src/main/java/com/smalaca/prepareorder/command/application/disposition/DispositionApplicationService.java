package com.smalaca.prepareorder.command.application.disposition;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.prepareorder.command.domain.disposition.Disposition;
import com.smalaca.prepareorder.command.domain.disposition.DispositionRepository;

import java.util.UUID;


@PrimaryAdapter
public class DispositionApplicationService {

    private final DispositionRepository dispositionRepository;

    public DispositionApplicationService(DispositionRepository dispositionRepository) {
        this.dispositionRepository = dispositionRepository;
    }

    public UUID confirmProducts(ConfirmationOfProductsCommand confirmationOfProductsCommand) {

        Disposition disposition = new Disposition();

        disposition.confirmProducts(confirmationOfProductsCommand.listOfProducts(), confirmationOfProductsCommand.transportType(),confirmationOfProductsCommand.addressVO(), confirmationOfProductsCommand.paymentType());

        dispositionRepository.save(disposition);

        return disposition.getID();
    }
}
