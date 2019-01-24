package com.zensar.techtest.constants;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {

    private Constants(){
        throw new IllegalStateException("Constants class");
    }

    public static final Map<String, String> BASIC_COLOR_TO_RGB = Stream.of(new Object[][]{
            {"Black", "000000"},
            {"White", "FFFFFF"},
            {"Red", "FF0000"},
            {"Lime", "00FF00"},
            {"Blue", "0000FF"},
            {"Yellow", "FFFF00"},
            {"Cyan", "00FFFF"},
            {"Magenta", "FF00FF"},
            {"Silver", "C0C0C0"},
            {"Gray", "808080"},
            {"Maroon", "800000"},
            {"Olive", "808000"},
            {"Green", "008000"},
            {"Purple", "800080"},
            {"Teal", "008080"},
            {"Navy", "000080"},

    }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

    public static final Map<String, String> CURRENCY_SYMBOL = Stream.of(new Object[][]{
            {"GBP", "£"}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));

    public static final String RGB_COLOR_NOT_FOUND = "na";
    public static final String DEFAULT_CURRENCY = "£";
    public static final String DEFAULT_LABELTYPE = "ShowWasNow";
}
