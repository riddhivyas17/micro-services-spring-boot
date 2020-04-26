package com.example.util;

public enum ServiceName {

	  PRODUCT_CATALOG_SERVICE("ProductCatalogService");

    private String name;

    ServiceName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
