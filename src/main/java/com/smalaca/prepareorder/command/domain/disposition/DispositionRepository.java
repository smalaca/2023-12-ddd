package com.smalaca.prepareorder.command.domain.disposition;


import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface DispositionRepository {

    public void save(Disposition disposition);

    public Disposition findById(UUID uuid);
}
