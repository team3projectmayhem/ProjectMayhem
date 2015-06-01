package edu.uw.ProjectMayhem.controllers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import edu.uw.ProjectMayhem.model.UploadService;

/**
 * Created by Brian on 6/1/2015.
 */
public class NetworkBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Intent upload = new Intent(context, UploadService.class);

        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();

        if (isConnected) {

            context.startService(upload);
        } else {

            context.stopService(upload);
        }
    }
}
