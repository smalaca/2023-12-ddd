package com.smalaca.prepareorder.command.application.disposition;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.prepareorder.command.domain.disposition.Disposition;
import com.smalaca.prepareorder.command.domain.disposition.DispositionRepository;
import com.smalaca.prepareorder.command.domain.shopping.Shopping;
import com.smalaca.prepareorder.command.domain.shopping.ShoppingRepository;

import java.util.UUID;


@PrimaryAdapter
public class DispositionApplicationService {

    private final DispositionRepository dispositionRepository;
    private final ShoppingRepository shoppingRepository;


    public DispositionApplicationService(DispositionRepository dispositionRepository, ShoppingRepository shoppingRepository) {
        this.dispositionRepository = dispositionRepository;
        this.shoppingRepository = shoppingRepository;
    }

    public UUID confirmProducts(DispositionCommand dispositionCommand) {

        Shopping shopping = shoppingRepository.findById(dispositionCommand.shoppingId());

        AddressVO addressVO = new AddressVO(dispositionCommand.street(),dispositionCommand.city(),dispositionCommand.houseNumber());

        Disposition disposition = shopping.confirmProducts(dispositionCommand.transportType(),addressVO, dispositionCommand.paymentType());

        if (disposition != null) {
            dispositionRepository.save(disposition);

            return disposition.getID();
        }
        else{
            return null;
        }
    }
}
