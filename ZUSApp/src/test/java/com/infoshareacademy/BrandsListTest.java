package com.infoshareacademy;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BrandsListTest {

    BrandsList sut = new BrandsList();

    BrandsListTest() throws IOException {
    }

    @Test
    void shouldGetBrandsList() throws IOException {
        //given

        //when
        List<Brands> result = sut.getBrandsList();

        //then
        assertThat(result).isNotEmpty();
    }


    @Test
    void shouldSelectLetter() {
        //given

        //when
        List result = sut.selectLetter("F");
        //then
        assertThat(result).isNotEmpty();
    }
}