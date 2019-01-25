package com.zensar.tech.model;

import java.util.Objects;

public class ColorSwatchRGB {
    private String color;
    private String rgbColor;
    private String skuId;

    public ColorSwatchRGB(String color, String rgbColor, String skuId){
        this.color = color;
        this.rgbColor = rgbColor;
        this.skuId = skuId;
    }

    public String getColor() {
        return color;
    }

    public String getRgbColor(){
        return this.rgbColor;
    }

    public String getSkuId(){
        return this.skuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorSwatchRGB that = (ColorSwatchRGB) o;
        return Objects.equals(color, that.color) &&
                Objects.equals(rgbColor, that.rgbColor) &&
                Objects.equals(skuId, that.skuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, rgbColor, skuId);
    }

    @Override
    public String toString() {
        return "ColorSwatchRGB{" +
                "color='" + color + '\'' +
                ", rgbColor='" + rgbColor + '\'' +
                ", skuId='" + skuId + '\'' +
                '}';
    }
}
