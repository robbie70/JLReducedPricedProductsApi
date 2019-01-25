package com.zensar.tech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductList {

    @JsonProperty("products")
    private List<Product> products;

    public ProductList() {
        //blank required for jackson
    }

    public List<Product> getProducts() {
        return products;
    }

}
