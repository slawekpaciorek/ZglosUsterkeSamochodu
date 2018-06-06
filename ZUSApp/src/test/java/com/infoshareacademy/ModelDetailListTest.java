package com.infoshareacademy;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelDetailListTest {

    ModelDetailList sut = new ModelDetailList();

    @Test
    void shouldGetModelDetails() throws IOException {
        //given

        //when
        List result = sut.getModelDetails("/api/v2/find/8ro/bbw");
        //then
        assertThat(result).isNotEmpty();
    }
}