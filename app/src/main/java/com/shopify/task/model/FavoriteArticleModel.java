package com.shopify.task.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity
public class FavoriteArticleModel {

    @Expose
    @PrimaryKey
    public Long  id;
    private String articleType;
    private String articletitle;
    private String articleDate;
    private String imageUrl;

    public FavoriteArticleModel(Long id, String articleType, String articletitle, String articleDate, String imageUrl) {
        this.articleType = articleType;
        this.articletitle = articletitle;
        this.articleDate = articleDate;
        this.id = id;
        this.imageUrl = imageUrl;

    }


    public String getArticleDate() {
        return articleDate;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public String getArticleType() {
        return articleType;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
