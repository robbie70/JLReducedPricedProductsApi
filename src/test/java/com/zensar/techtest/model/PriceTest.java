package com.zensar.techtest.model;

import TestDataGenerator.TestDataGenerator;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PriceTest {

    @Test
    public void shouldConvertJsonIntoPrice() {
        Price readValue = TestDataGenerator.createPriceRecordWithStringInPriceNow();
        assertEquals("", readValue.was);
        assertEquals("", readValue.then1);
        assertEquals("", readValue.then2);
        assertEquals("59.00", readValue.now);
        assertEquals("", readValue.uom);
        assertEquals("GBP", readValue.currency);
    }

    @Test
    public void shouldConvertJsonProductIntoPrice() {
        Product readValue = TestDataGenerator.createProductRecordWithStringInPriceNow();
        assertEquals("3525085", readValue.productId);
        assertEquals("hush Tasha Vest Dress", readValue.title);
        assertEquals("", readValue.price.then1);
        assertEquals("55.00", readValue.price.now);
        assertEquals("Blue", readValue.colorSwatches[1].basicColor);
        assertEquals("237494562", readValue.colorSwatches[1].skuId);
    }

    @Test
    public void shouldConvertJsonProductListIntoPrice() {
        ProductList readValue;
        readValue = TestDataGenerator.createProductListRecordWithStringInPriceNow();
        assertEquals("3525085", readValue.getProducts().get(0).productId);
        assertEquals("hush Tasha Vest Dress", readValue.getProducts().get(0).title);
        assertEquals("", readValue.getProducts().get(0).price.then1);
        assertEquals("59.00", readValue.getProducts().get(0).price.now);
        assertEquals("Blue", readValue.getProducts().get(0).colorSwatches[1].basicColor);
        assertEquals("237494562", readValue.getProducts().get(0).colorSwatches[1].skuId);
    }

    @Test
    public void shouldConvertJsonProductListIntoPriceWhenNowAnObject() {
        ProductList readValue;
        readValue = TestDataGenerator.createProductListRecordWithObjectInPriceNow();
        assertEquals("3525085", readValue.getProducts().get(0).productId);
        assertEquals("hush Tasha Vest Dress", readValue.getProducts().get(0).title);
        assertEquals("", readValue.getProducts().get(0).price.then1);
        List priceNowList = (List) readValue.getProducts().get(0).price.now;
        assertEquals("55.00", ((Map) priceNowList.get(0)).get("from"));
        assertEquals("100.00", ((Map) priceNowList.get(0)).get("to"));
        assertEquals("Blue", readValue.getProducts().get(0).colorSwatches[1].basicColor);
        assertEquals("237494562", readValue.getProducts().get(0).colorSwatches[1].skuId);
    }
}
