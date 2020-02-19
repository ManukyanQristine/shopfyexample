package com.shopify.task.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.shopify.task.interfaces.BorrowModelDao;
import com.shopify.task.model.FavoriteArticleModel;

@Database(entities = {FavoriteArticleModel.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "borrow_db")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract BorrowModelDao itemAndPersonModel();

}
