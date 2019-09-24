package com.android.foregorundservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;

import static com.android.foregorundservice.App.channel1;
import static com.android.foregorundservice.App.channel2;


public class NotificationService extends Service {
    String TAG = "WEW";
    private NotificationManagerCompat notificationManagerCompat;
    private Notification notification;
    private Notification notification2;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        notification = new Notification.Builder(this, channel1)
                .setContentText("AUDIO BRRRrrr...")
                .setContentTitle("AUDIO TITLE")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build();
        notification2 = new Notification.Builder(this, channel2)
                .setContentText("Video BRRRrrr...")
                .setContentTitle("Video TITLE")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: " + startId);
        startForeground(startId, notification);
        startForeground(startId, notification2);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopSelf();
       return START_NOT_STICKY;
    }
}
