package com.zensar.techtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zensar.techtest.constants.Constants;
import com.zensar.techtest.converters.Converters;
import com.zensar.techtest.utils.CommonUtils;

import java.util.Arrays;
import java.util.Objects;

public class ReducedPriceProduct {

    @JsonIgnore
    private static final String NOW_LITERAL = ", now ";
    @JsonIgnore
    private final Double wasPriceDbl;
    @JsonIgnore
    private final Double nowPriceDbl;
    @JsonIgnore
    private final String currencySymbol;

    @JsonProperty("productId")
    private final String productId;
    @JsonProperty("title")
    private final String title;
    @JsonProperty("ColorSwatches")
    private final ColorSwatchRGB [] colorSwatches;
    @JsonProperty("nowPrice")
    private final String nowPrice;
    @JsonProperty("priceLabel")
    final String priceLabel;

    public ReducedPriceProduct (final Product product, final String labelType){
        this.productId = product.productId;
        this.title = product.title;
        this.colorSwatches = Converters.colorSwatchToColorSwatchRGB(product.colorSwatches);
        currencySymbol = CommonUtils.lookupCurrencySymbol(product.price.currency);
        nowPriceDbl = Converters.priceNowObjectToDouble(product.price.now);
        nowPrice = currencySymbol + CommonUtils.formatPrice(nowPriceDbl);
        wasPriceDbl = Converters.priceNowObjectToDouble(product.price.was);
        this.priceLabel = formatPriceLabel(product.price, labelType);
    }

    @JsonIgnore
    public Double getPriceReduction(){
        return this.wasPriceDbl - this.nowPriceDbl;
    }

    private String formatPriceLabel(Price price, final String pLabelType){
        String result;
        String labelType = (pLabelType == null ? Constants.DEFAULT_LABELTYPE : pLabelType);
        switch (labelType.toLowerCase()){
            case "showwasnow":
                result = formatShowWasNow();
                break;
            case "showwasthennow" :
                result = formatShowWasThenNow(price);
                break;
            case "showpercdscount" :
                result = formatShowPercDscount();
                break;
            default:
                result = formatShowWasNow();
                break;
        }
        return result;
    }

    private String formatShowPercDscount() {
        Double discount = calcDiscount();
        String result = "";
        if (discount > 0){
            result = CommonUtils.formatPrice(discount) + "% off - now " + this.nowPrice;
        }else{
            // a price increase (i.e PriceNow > PriceWas is an unsupported operation so returning empty discount.
        }
        return result;
    }

    private String formatShowWasThenNow(Price price){
        String result;
        String wasPrice = currencySymbol + CommonUtils.formatPrice(wasPriceDbl);
        String thenPrice = currencySymbol + CommonUtils.formatPrice(calcThenPrice(price));

        if (!thenPrice.equals("£0.00")){
            result = "Was " + wasPrice + ", then " + thenPrice + NOW_LITERAL + this.nowPrice;
        }else{
            result = "Was " + wasPrice + NOW_LITERAL + this.nowPrice;
        }
        return result;
    }

    private String formatShowWasNow(){
        String wasPrice = currencySymbol + CommonUtils.formatPrice(wasPriceDbl);
        return "Was " + wasPrice + NOW_LITERAL + this.nowPrice;
    }


    private Double calcDiscount(){
         return ((getPriceReduction())/(wasPriceDbl)) * 100;
    }

    private static Double calcThenPrice(Price price) {
        Double thenResult = 0D;
        Double then1Price = Converters.convertToDouble(price.then1);
        Double then2Price = Converters.convertToDouble(price.then2);

        if (then2Price != null && then2Price != 0) {
            thenResult = then2Price;
        } else if (then1Price != null && then1Price != 0){
            thenResult = then1Price;
        }

        return thenResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReducedPriceProduct that = (ReducedPriceProduct) o;
        return wasPriceDbl.equals(that.wasPriceDbl) &&
                nowPriceDbl.equals(that.nowPriceDbl) &&
                currencySymbol.equals(that.currencySymbol) &&
                productId.equals(that.productId) &&
                title.equals(that.title) &&
                Arrays.equals(colorSwatches, that.colorSwatches) &&
                nowPrice.equals(that.nowPrice) &&
                priceLabel.equals(that.priceLabel);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(wasPriceDbl, nowPriceDbl, currencySymbol, productId, title, nowPrice, priceLabel);
        result = 31 * result + Arrays.hashCode(colorSwatches);
        return result;
    }

    @Override
    public String toString() {
        return "ReducedPriceProduct{" +
                "wasPriceDbl=" + wasPriceDbl +
                ", nowPriceDbl=" + nowPriceDbl +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", productId='" + productId + '\'' +
                ", title='" + title + '\'' +
                ", colorSwatches=" + Arrays.toString(colorSwatches) +
                ", nowPrice='" + nowPrice + '\'' +
                ", priceLabel='" + priceLabel + '\'' +
                '}';
    }
}
