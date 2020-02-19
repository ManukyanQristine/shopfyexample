
package com.shopify.task.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseData {


    @SerializedName("products")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
