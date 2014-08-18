package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tobyretallick on 17/08/2014.
 */

public class ConverterShould {

    Converter converter;

    @Before
    public void setUp() {
        converter = new Converter();
    }

    @Test
    public void should_convert_5_to_V() {
        converter.convert(5);
        assertThat(converter.convert(5), is("V"));
    }

    @Test
    public void should_list_conversionTable_in_reverse_order() {
        Object firstKey = Converter.table.keySet().toArray()[0];
        Object firstValue = Converter.table.get(firstKey);
        assertThat(firstValue, is("M"));
    }

    @Test
    public void should_convert_22_to_XXII() {
        converter.convert(22);
        assertThat(converter.convert(22), is("XXII"));
    }

    @Test
    public void should_convert_14_to_XIV() {
        converter.convert(14);
        assertThat(converter.convert(14), is("XIV"));
    }

    @Test
    public void should_convert_940_to_CMXL() {
        converter.convert(940);
        assertThat(converter.convert(940), is("CMXL"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_null_value_converted() {
        converter.convert(null);
    }
}
