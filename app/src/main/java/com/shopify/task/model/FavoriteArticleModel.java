package com.shopify.task.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity
public class FavoriteArticleModel {

    @Expose
    @PrimaryKey
    public Long  id;
    private String productType;
    private String productTitle;
    private String productPrice;
    private String imageUrl;

    public FavoriteArticleModel(Long id, String productType, String productTitle, String productPrice, String imageUrl) {
        this.productType = productType;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.id = id;
        this.imageUrl = imageUrl;

    }


    public String getProductPrice() {
        return productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductType() {
        return productType;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
