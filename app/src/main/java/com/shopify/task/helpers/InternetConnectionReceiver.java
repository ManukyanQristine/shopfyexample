package com.shopify.task.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.shopify.task.R;

public class InternetConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isOnline(context))
            Toast.makeText(context, context.getString(R.string.internet_connected), Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, context.getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show();

    }

    public boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }
}
