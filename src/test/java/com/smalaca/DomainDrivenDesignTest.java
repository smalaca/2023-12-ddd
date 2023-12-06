package com.smalaca;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DomainDrivenDesignTest {

    @Test
    void shouldRecognizeIfDDDHelps() {
        boolean actual = new DomainDrivenDesign().doesItHelp();

        assertThat(actual).isTrue();
    }
}
