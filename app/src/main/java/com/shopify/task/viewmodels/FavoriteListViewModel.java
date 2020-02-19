package com.shopify.task.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.shopify.task.db.AppDatabase;
import com.shopify.task.model.FavoriteArticleModel;

import java.util.List;


public class FavoriteListViewModel extends AndroidViewModel {

    private final LiveData<List<FavoriteArticleModel>> itemAndPersonList;

    private AppDatabase appDatabase;

    public FavoriteListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
        itemAndPersonList = appDatabase.itemAndPersonModel().getAllBorrowedItems();
    }


    public LiveData<List<FavoriteArticleModel>> getItemAndPersonList() {
        return itemAndPersonList;
    }

}
