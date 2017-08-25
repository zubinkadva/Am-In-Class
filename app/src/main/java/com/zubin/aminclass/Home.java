package com.zubin.aminclass;

/*
* Copyright 2017 Zubin Kadva
*/

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Calendar;

public class Home extends AppCompatActivity {

    PendingIntent pendingIntent;
    int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // CN    DS    ACV    CSS    WORK
        int[] times = {15, 23, 16, 52, 7, 53, 9, 22, 10, 53, 12, 22, 11, 53, 12, 57, 20, 0};
        for (int i = 1; i <= times.length; i += 2) {
            Intent alarmIntent = new Intent(Home.this, AlarmReceiver.class);
            alarmIntent.putExtra("id", id);
            pendingIntent = PendingIntent.getBroadcast(Home.this, id, alarmIntent, 0);
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, times[i - 1]);
            calendar.set(Calendar.MINUTE, times[i]);
            manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent);
            id++;
        }
    }
}
