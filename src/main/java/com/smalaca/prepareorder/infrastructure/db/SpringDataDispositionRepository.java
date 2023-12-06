package com.smalaca.prepareorder.infrastructure.db;

import com.smalaca.prepareorder.command.domain.disposition.Disposition;
import com.smalaca.prepareorder.command.domain.disposition.DispositionRepository;


import java.util.UUID;

public class SpringDataDispositionRepository implements DispositionRepository {
    @Override
    public Disposition findById(UUID uuid) {
        return null;
    }

    @Override
    public void save(Disposition assortment) {}
}
