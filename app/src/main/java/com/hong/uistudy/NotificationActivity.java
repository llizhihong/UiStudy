package com.hong.uistudy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

/**
 * author：lzh on 2016/12/22 15:14
 * depic：通知栏
 */
public class NotificationActivity extends AppCompatActivity implements View.OnClickListener{
    private NotificationManager notificationManager;
    private Notification notification;
    private final int NOTIFICATION_ID = 0;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initNotiFication();
    }

    private void initNotiFication() {
        //获取NotificationManager对象
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent mainIntent = new Intent(this, MainActivity.class);
        pendingIntent = PendingIntent.getActivity(this, 0, mainIntent, PendingIntent.FLAG_NO_CREATE);
        notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("标题")
                .setContentText("内容")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .build();
        notification.sound = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,"3");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showNotification:
                notificationManager.notify(NOTIFICATION_ID, notification);
                break;
            case R.id.btn_updateNotification:
                notification = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("update标题50%")
                        .setContentText("update内容")
                        .setAutoCancel(false)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)
                        .setProgress(100, 50, false)
                        .build();
                notificationManager.notify(NOTIFICATION_ID, notification);
                break;
            case R.id.btn_clearNotification:
                notificationManager.cancel(NOTIFICATION_ID);
                break;
        }
    }
}
