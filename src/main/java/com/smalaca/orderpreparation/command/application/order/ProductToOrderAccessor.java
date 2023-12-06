package com.smalaca.orderpreparation.command.application.order;

import java.util.UUID;

public interface ProductToOrderAccessor {

    Object read(UUID id);

}
