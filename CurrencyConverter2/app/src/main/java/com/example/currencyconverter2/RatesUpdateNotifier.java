package com.example.currencyconverter2;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
//import android.support.v4.app.NotificationCompat;

import androidx.core.app.NotificationCompat;

/**
 * A notifier class which notifies the user after the rates have been updated
 */
public class RatesUpdateNotifier {

    private static final int NOTIFICATION_ID = 1;

    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager;

    public RatesUpdateNotifier(Context context) {
        notificationBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.rates_updated)
                .setContentTitle("Updated Currencies!")
                .setContentText("Everything fresh...")
                .setAutoCancel(true);

        Intent resultIntent = new Intent(context, MainActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context,
                0, resultIntent, 0);
        notificationBuilder.setContentIntent(resultPendingIntent);

        notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void showOrUpdateNotification() {
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }
}


