package com.infoshareacademy;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelsListTest {

    ModelsList sut = new ModelsList();

    @Test
    void shouldGetModelsList() throws IOException {
        //given

        //when
        List result = sut.getModelsList("/api/v2/find/y2");

        //then
        assertThat(result).isNotEmpty();
    }

    @Test
    void shouldGetModelsListNames() throws IOException {
        //given

        //when
        List result = sut.getModelsListNames("/api/v2/find/y2");

        //then
        assertThat(result).isNotEmpty();
    }
}