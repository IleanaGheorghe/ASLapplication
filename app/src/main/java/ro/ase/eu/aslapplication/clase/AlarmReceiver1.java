package ro.ase.eu.aslapplication.clase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import ro.ase.eu.aslapplication.NotificationActivity;
import ro.ase.eu.aslapplication.R;

/**
 * Created by Ileana Gheorghe on 6/8/2018.
 */

public class AlarmReceiver1 extends BroadcastReceiver {
    int MID=0;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        //getSearchExpression(id);

        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, NotificationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.ic_notif)
                .setContentTitle("Notificare")
                .setContentText("Nu uitati sa verificati cuvantul zilei: "+NotificationActivity.nume).setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setStyle(new android.support.v4.media.app.NotificationCompat.MediaStyle())
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;
    }

}
