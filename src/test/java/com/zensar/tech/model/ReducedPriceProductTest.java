package com.zensar.tech.model;

import TestDataGenerator.TestDataGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReducedPriceProductTest {

    @Test
    public void shouldReturnReducedPriceProductForPriceLabelShowWasNow(){
        String content = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"100\",\"then1\": \"\",\"then2\": \"\",\"now\": \"55.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}";
        String labelType = "ShowWasNow";
        Product product = TestDataGenerator.createProductRecordWithStringInPriceNow(content);
        ReducedPriceProduct undertest = new ReducedPriceProduct(product, labelType);
        assertEquals("Was £100, now £55", undertest.priceLabel);
    }

    @Test
    public void shouldReturnReducedPriceProductForPriceLabelShowWasThenNowWhenThen2NotEmpty(){
        String content = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"99.99\",\"then1\": \"\",\"then2\": \"89.99\",\"now\": \"55.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}";
        String labelType = "ShowWasThenNow";
        Product product = TestDataGenerator.createProductRecordWithStringInPriceNow(content);
        ReducedPriceProduct undertest = new ReducedPriceProduct(product, labelType);
        assertEquals("Was £99.99, then £89.99, now £55", undertest.priceLabel);
    }

    @Test
    public void shouldReturnReducedPriceProductForPriceLabelShowWasThenNowWhenThen2EmptyThen1NotEmpty(){
        String content = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"99.99\",\"then1\": \"79.99\",\"then2\": \"\",\"now\": \"55.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}";
        String labelType = "ShowWasThenNow";
        Product product = TestDataGenerator.createProductRecordWithStringInPriceNow(content);
        ReducedPriceProduct undertest = new ReducedPriceProduct(product, labelType);
        assertEquals("Was £99.99, then £79.99, now £55", undertest.priceLabel);
    }

    @Test
    public void shouldReturnReducedPriceProductForPriceLabelShowWasThenNowWhenThen2EmptyAndThen1Empty(){
        String content = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"99.99\",\"then1\": \"\",\"then2\": \"\",\"now\": \"55.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}";
        String labelType = "ShowWasThenNow";
        Product product = TestDataGenerator.createProductRecordWithStringInPriceNow(content);
        ReducedPriceProduct undertest = new ReducedPriceProduct(product, labelType);
        assertEquals("Was £99.99, now £55", undertest.priceLabel);
    }

    @Test
    public void shouldReturnReducedPriceProductForPriceLabelShowPercDscount(){
        String content = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"100.00\",\"then1\": \"\",\"then2\": \"\",\"now\": \"50.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}";
        String labelType = "ShowPercDscount";
        Product product = TestDataGenerator.createProductRecordWithStringInPriceNow(content);
        ReducedPriceProduct undertest = new ReducedPriceProduct(product, labelType);
        assertEquals("50% off - now £50", undertest.priceLabel);
    }

    @Test
    public void shouldReturnReducedPriceProductForDefaultPriceLabelWhenNoParmSpecified(){
        String content = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                "\"price\": {\"was\": \"100\",\"then1\": \"\",\"then2\": \"\",\"now\": \"55.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                "}";
        String labelType = "";
        Product product = TestDataGenerator.createProductRecordWithStringInPriceNow(content);
        ReducedPriceProduct undertest = new ReducedPriceProduct(product, labelType);
        assertEquals("Was £100, now £55", undertest.priceLabel);
    }

}
