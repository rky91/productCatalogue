package com.b2c.productcatalogue.utils;

public enum ProductGroupBy {

    BRAND("brand"),
    COLOR("color"),
    SIZE("size"),
    SELLER("seller");
    String value;

    ProductGroupBy(String name) {
        value = name;
    }

    String getValue() {
        return value;
    }

}
