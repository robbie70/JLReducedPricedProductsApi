package com.zensar.tech.converters;

import com.zensar.tech.model.ColorSwatch;
import com.zensar.tech.model.ColorSwatchRGB;
import com.zensar.tech.utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public class Converters {

    private Converters(){
        throw new IllegalStateException("Converters class");
    }

    public static ColorSwatchRGB [] colorSwatchToColorSwatchRGB(final ColorSwatch [] colorSwatch) {
        ColorSwatchRGB [] result = new ColorSwatchRGB[colorSwatch.length];
        for (int i = 0; i < colorSwatch.length; i++){
            result[i] = colorSwatchToColorSwatchRGB(colorSwatch[i]);
        }
        return result;
    }

    static ColorSwatchRGB colorSwatchToColorSwatchRGB(final ColorSwatch colorSwatch) {
        return new ColorSwatchRGB(colorSwatch.getBasicColor(), CommonUtils.lookupRGBCOlor(colorSwatch.getBasicColor()), colorSwatch.getSkuId());
    }

    public static Double priceNowObjectToDouble(final Object pNow){
        //if Price.now is a String
        if (pNow instanceof String){
            String sNow = String.valueOf(pNow);
            return convertToDouble(sNow);
        //otherwise if Price.now is an Object
        }else{
            Map now = (HashMap) pNow;
            try {
                //assumption here is that to convert this complex object we return the average value
                Double from = Double.valueOf((String) now.get("from"));
                Double to = Double.valueOf((String) now.get("to"));
                return (from + to) / 2;
            }catch(NumberFormatException nfe){
                return 0D;
            }
        }
    }

    public static Double convertToDouble(final String in){
        try{
            return Double.valueOf(in);
        }catch(NumberFormatException nfe){
            return 0D;
        }
    }

}
