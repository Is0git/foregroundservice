package com.android.foregorundservice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;

public class App extends Application {
public static final String channel1 = "sound";
public static final String channel2 = "video";
    @Override
    public void onCreate() {
        super.onCreate();
        createChannels();
        Intent intent = new Intent(this, NotificationService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        }
    }

    public void createChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channel1, "this is sound channel", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Notification just to handle audio");
            notificationChannel.setName("sound channel");
            NotificationChannel notificationChannel12 = new NotificationChannel(channel2, "this is video channel", NotificationManager.IMPORTANCE_LOW);
            notificationChannel12.setDescription("For video");
            notificationChannel12.setName("video channel");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.createNotificationChannel(notificationChannel12);
        }

    }
}
