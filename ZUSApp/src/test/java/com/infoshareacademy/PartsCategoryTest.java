package com.infoshareacademy;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PartsCategoryTest {

    PartsCategory sut = new PartsCategory();

    @Test
    void shouldGetPartsCategory() throws IOException {
        //given

        //when
        List result = sut.getPartsCategory("/api/v2/find/8ro/bbw/pzl");

        //then
        assertThat(result).isNotEmpty();
    }

    @Test
    void shouldPartsCategorySubList() throws IOException {
        //given

        //when
        List result = sut.partsCategorySubList("/api/v2/find/8ro/bbw/pzl");

        //then
        assertThat(result).isNotEmpty();
    }

/*    @Test
    void shouldGetStockList() throws IOException {
        //given

        //when
        List result = sut.getStockList("/api/v2/find/8ro/bbw/pzl");

        //then
        assertThat(result).isNotEmpty();
    }*/
}