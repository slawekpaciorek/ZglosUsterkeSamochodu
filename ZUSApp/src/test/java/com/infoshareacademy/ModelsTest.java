package com.infoshareacademy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelsTest {

    Models sut = new Models();

    @Test
    void shouldEndDateProduction() {
        //given

        //when
        String result = sut.endDateProduction();

        //then
        assertThat(result).isNotEmpty();
    }
}