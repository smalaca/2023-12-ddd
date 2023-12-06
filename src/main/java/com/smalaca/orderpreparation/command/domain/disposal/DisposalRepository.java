package com.smalaca.orderpreparation.command.domain.disposal;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface DisposalRepository {
    UUID save(Disposal disposal);
}
