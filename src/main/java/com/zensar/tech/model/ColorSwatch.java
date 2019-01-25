package com.zensar.tech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ColorSwatch {

    @JsonProperty("basicColor")
    String basicColor;

    @JsonProperty("skuId")
    String skuId;

    public ColorSwatch(){
        //blank constructor for JSON
    }

    public ColorSwatch(String basicColor, String skuId){
        this.basicColor = basicColor;
        this.skuId = skuId;
    }

    public String getBasicColor() {
        return basicColor;
    }

    public String getSkuId() {
        return skuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorSwatch that = (ColorSwatch) o;
        return Objects.equals(basicColor, that.basicColor) &&
                Objects.equals(skuId, that.skuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basicColor, skuId);
    }

    @Override
    public String toString() {
        return "ColorSwatch{" +
                "basicColor='" + basicColor + '\'' +
                ", skuId='" + skuId + '\'' +
                '}';
    }
}
