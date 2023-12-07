package com.smalaca.sharedkernel.domain.time;

import java.time.LocalDateTime;

public interface TimeProvider {

    LocalDateTime currentTime();

}
