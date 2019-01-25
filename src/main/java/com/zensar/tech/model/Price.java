package com.zensar.tech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Price {

    @JsonProperty("was")
    String was;
    @JsonProperty("then1")
    String then1;
    @JsonProperty("then2")
    String then2;
    @JsonProperty("now")
    Object now;
    @JsonProperty("uom")
    String uom;
    @JsonProperty("currency")
    String currency;

    public Price(){
        //blank constructor for JSON
    }

    public Object getNow(){
        return now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(was, price.was) &&
                Objects.equals(then1, price.then1) &&
                Objects.equals(then2, price.then2) &&
                Objects.equals(now, price.now) &&
                Objects.equals(uom, price.uom) &&
                Objects.equals(currency, price.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(was, then1, then2, now, uom, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "was='" + was + '\'' +
                ", then1='" + then1 + '\'' +
                ", then2='" + then2 + '\'' +
                ", now=" + now +
                ", uom='" + uom + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
