package com.zensar.techtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

public class Product {

    @JsonProperty("productId")
    String productId;

    @JsonProperty("title")
    String title;

    @JsonProperty("colorSwatches")
    ColorSwatch [] colorSwatches;

    @JsonProperty("price")
    Price price;

    public Product(){
        // blank required for Jackson
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(title, product.title) &&
                Arrays.equals(colorSwatches, product.colorSwatches) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productId, title, price);
        result = 31 * result + Arrays.hashCode(colorSwatches);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", title='" + title + '\'' +
                ", colorSwatches=" + Arrays.toString(colorSwatches) +
                ", price=" + price +
                '}';
    }
}
