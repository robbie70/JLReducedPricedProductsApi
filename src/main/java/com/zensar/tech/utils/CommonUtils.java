package com.zensar.tech.utils;

import com.zensar.tech.constants.Constants;

import java.util.Map;

public class CommonUtils {

    private CommonUtils(){
        throw new IllegalStateException("CommonUtils class");
    }

    public static String lookupRGBCOlor(final String basicColor) {
        return Constants.BASIC_COLOR_TO_RGB.entrySet()
                .stream()
                .filter(e -> e.getKey().equalsIgnoreCase(basicColor))
                .findFirst() // process the Stream until the first match is found
                .map(Map.Entry::getValue) // return the value of the matching entry if found
                .orElse(Constants.RGB_COLOR_NOT_FOUND); // return -1 if no match was found
    }

    public static String lookupCurrencySymbol(final String currency) {
        return Constants.CURRENCY_SYMBOL.entrySet()
                .stream()
                .filter(e -> e.getKey().equalsIgnoreCase(currency))
                .findFirst() // process the Stream until the first match is found
                .map(Map.Entry::getValue) // return the value of the matching entry if found
                .orElse(Constants.DEFAULT_CURRENCY); // return £ if no match was found
    }

    public static String formatPrice(final Double doubleValue){
        String result;
        if (doubleValue == null){
            result = "0.00";
        }else if (doubleValue % 1 == 0) { //whole number
            if (doubleValue < 10){
                result = String.format("%.2f", doubleValue);
            }else{
                result = String.valueOf(doubleValue.intValue());
            }
        }else{ //floating point number
            result = String.format( "%.2f", doubleValue);
        }
        return result;
    }
}
