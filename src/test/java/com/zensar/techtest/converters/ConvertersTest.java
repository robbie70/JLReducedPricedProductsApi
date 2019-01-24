package com.zensar.techtest.converters;

import TestDataGenerator.TestDataGenerator;
import com.zensar.techtest.model.ColorSwatch;
import com.zensar.techtest.model.ColorSwatchRGB;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertersTest {

    @Test
    public void shouldReturnRGBColourForInputColourBlack(){
        ColorSwatch colorSwatch = new ColorSwatch("black", "1234");
        ColorSwatchRGB colorSwatchRGB = Converters.colorSwatchToColorSwatchRGB(colorSwatch);
        assertEquals("black", colorSwatchRGB.getColor());
        assertEquals("000000", colorSwatchRGB.getRgbColor());
        assertEquals("1234", colorSwatchRGB.getSkuId());
    }

    @Test
    public void shouldReturnRGBColourForInputColourGreen(){
        ColorSwatch colorSwatch = new ColorSwatch("green", "1234");
        ColorSwatchRGB colorSwatchRGB = Converters.colorSwatchToColorSwatchRGB(colorSwatch);
        assertEquals("green", colorSwatchRGB.getColor());
        assertEquals("008000", colorSwatchRGB.getRgbColor());
        assertEquals("1234", colorSwatchRGB.getSkuId());
    }

    @Test
    public void shouldReturnMinusOneForInputColourNotFound(){
        ColorSwatch colorSwatch = new ColorSwatch("xyz", "1234");
        ColorSwatchRGB colorSwatchRGB = Converters.colorSwatchToColorSwatchRGB(colorSwatch);
        assertEquals("xyz", colorSwatchRGB.getColor());
        assertEquals("na", colorSwatchRGB.getRgbColor());
        assertEquals("1234", colorSwatchRGB.getSkuId());
    }

    @Test
    public void shouldReturnAverageOfNowPrice(){
        assertEquals(77.5D, Converters.priceNowObjectToDouble(TestDataGenerator.createPriceRecordWithObjectInPriceNow().getNow()), 0);
    }

    @Test
    public void shouldReturnNowPriceAsInput(){
        assertEquals(59D, Converters.priceNowObjectToDouble(TestDataGenerator.createPriceRecordWithStringInPriceNow().getNow()), 0);
    }

    @Test
    public void shouldDetectIntegerNotDouble() {
        String num = "20";
        try {
            assertEquals(20, Converters.convertToDouble(num), 0);
        } catch (NumberFormatException nfe) {
            fail();
        }
    }

    @Test
    public void shouldDetectDoubleIsWhole() {
        Double num = Converters.convertToDouble("20.00");
        try {
            assertEquals(0, num % 1, 0.0);
        } catch (NumberFormatException nfe) {
            fail();
        }
    }

    @Test
    public void shouldDetectDoubleIsNotWhole() {
        Double num = Converters.convertToDouble("20.10");
        try {
            assertNotEquals(0, num % 1, 0.0);
        } catch (NumberFormatException nfe) {
            fail();
        }
    }

}
