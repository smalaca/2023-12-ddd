package com.smalaca.orderpreparation.infrastructure.repository.disposal;

import com.smalaca.annotation.architecture.SecondaryAdapter;
import com.smalaca.orderpreparation.command.domain.disposal.Disposal;
import com.smalaca.orderpreparation.command.domain.disposal.DisposalRepository;

import java.util.UUID;

@SecondaryAdapter
public class SpringDataDisposalRepository implements DisposalRepository {
    @Override
    public UUID save(Disposal disposal) {
        return null;
    }
}
