package com.zensar.tech.controller;

import com.zensar.tech.model.Product;
import com.zensar.tech.model.ProductList;
import com.zensar.tech.model.ReducedPriceProduct;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class is the oontroller for the products service. There are two supported services, one to return a list of all the category 600001506
 * products and the other to only return a list of the Reduced Price Products.
 *
 * @author  Robert Stannard
 * @version 1.0.0
 * @since   2019-01-25
 */
@RestController
public class ProductController {

    private final RestTemplate restTemplate;

    public ProductController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Produces a list of products of category 600001506
     *
     * @return list of all products
     */
    @RequestMapping(value = "/api/600001506/allproducts", produces = "application/json")
    private List<Product> getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-version", "2");
        HttpEntity<ProductList> entity = new HttpEntity<>(headers);

        ResponseEntity<ProductList> restRes = restTemplate.exchange("https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma", HttpMethod.GET, entity, ProductList.class);

        ProductList result = restRes.getBody();

        return result != null ? result.getProducts() : null;
    }

    /**
     * Produces a list of reduced priced products of category 600001506
     *
     * @param  labelType an identifier to determine different ways of displaying the label information.
     *                   Supported values are, "ShowWasNow", "ShowWasThenNow" and "ShowPercDscount"
     * @return list of all reduced priced products of category 60001506 sorted by products with the greatest price reduction first
     */
    @RequestMapping(value = "/api/600001506/getreducedproductslist", produces = "application/json")
    public List<ReducedPriceProduct> getReducedProductsList(@RequestParam(value = "labelType", required = false) String labelType) {
        List<Product> productList = getProductList();
        List<ReducedPriceProduct> result = new ArrayList<>();

        if (productList != null) {
            for (Product each : productList){
                ReducedPriceProduct reducedPriceProduct = new ReducedPriceProduct(each, labelType);
                if (reducedPriceProduct.getPriceReduction() > 0) {
                    result.add(reducedPriceProduct);
                }
            }
        }

        result.sort(new SortByPriceReductionDescending());
        return result;
    }

    class SortByPriceReductionDescending implements Comparator<ReducedPriceProduct>
    {
        // Used for sorting in descending order of price reductions
        public int compare(ReducedPriceProduct a, ReducedPriceProduct b)
        {
            return b.getPriceReduction().compareTo(a.getPriceReduction());
        }
    }

}
