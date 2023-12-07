package com.smalaca.sharedkernel.domain.eventbus;

import com.smalaca.annotation.architecture.SecondaryPort;

@SecondaryPort
public interface EventBus {

    void fire(Object event);

}
