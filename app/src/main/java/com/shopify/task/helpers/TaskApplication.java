package com.shopify.task.helpers;

import android.app.Application;
import android.content.Context;

public class TaskApplication extends Application {

    private static TaskApplication instance;
    private static ApiManager apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        apiManager = ApiManager.getInstance();
    }

    public static Context getContext(){
        return instance;
    }
}
