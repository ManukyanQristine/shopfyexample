package com.shopify.task.helpers;

import android.os.AsyncTask;

import com.shopify.task.db.AppDatabase;
import com.shopify.task.model.FavoriteArticleModel;

public class RoomRepo {

    private AppDatabase appDatabase;


    public RoomRepo() {
        appDatabase = AppDatabase.getDatabase(TaskApplication.getContext());
    }

    public void addBorrow(final FavoriteArticleModel borrowModel) {
        new addAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class addAsyncTask extends AsyncTask<FavoriteArticleModel, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final FavoriteArticleModel... params) {
            System.out.println("XXX : " + db.itemAndPersonModel().isFavorite(params[0].getId()));
            if (db.itemAndPersonModel().isFavorite(params[0].getId()) == null) {
                db.itemAndPersonModel().addBorrow(params[0]);
            }
            return null;
        }

    }

    public void deleteItem(FavoriteArticleModel borrowModel) {
        new deleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class deleteAsyncTask extends AsyncTask<FavoriteArticleModel, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final FavoriteArticleModel... params) {
            db.itemAndPersonModel().deleteBorrow(params[0]);
            return null;
        }

    }
}
