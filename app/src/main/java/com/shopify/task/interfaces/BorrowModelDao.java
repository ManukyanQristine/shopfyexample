package com.shopify.task.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.shopify.task.model.FavoriteArticleModel;

import java.util.List;



@Dao
public interface BorrowModelDao {

    @Query("select * from FavoriteArticleModel")
    LiveData<List<FavoriteArticleModel>> getAllBorrowedItems();

    @Query("select * from FavoriteArticleModel where id = :id")
    FavoriteArticleModel isFavorite(Long id);



    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    void addBorrow(FavoriteArticleModel borrowModel);

    @Delete
    void deleteBorrow(FavoriteArticleModel borrowModel);

}
