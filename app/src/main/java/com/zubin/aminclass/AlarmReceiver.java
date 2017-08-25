package com.zubin.aminclass;

/*
* Copyright 2017 Zubin Kadva
*/

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {

    AudioManager am;

    public void onReceive(Context context, Intent intent) {
        int id = intent.getIntExtra("id", 1);
        am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        // CN DAYS
        if (day == Calendar.MONDAY || day == Calendar.WEDNESDAY) {
            if (id == 1) silence();
            else if (id == 2) workRing();
        }

        // DS DAYS
        if (day == Calendar.TUESDAY || day == Calendar.THURSDAY) {
            if (id == 3) silence();
            else if (id == 4) workRing();
        }

        // ACV DAYS
        if (day == Calendar.TUESDAY || day == Calendar.THURSDAY) {
            if (id == 5) silence();
            else if (id == 6) workRing();
        }

        // CSS DAYS
        if (day == Calendar.FRIDAY) {
            if (id == 7) silence();
            else if (id == 8) workRing();
        }

        // NON WORK HOURS
        if (id == 9) loudRing();
    }

    public void silence() {
        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }

    public void workRing() {
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        am.setStreamVolume(AudioManager.STREAM_RING, 1, 0);
    }

    public void loudRing() {
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        am.setStreamVolume(AudioManager.STREAM_RING,
                am.getStreamMaxVolume(AudioManager.STREAM_RING), 0);
    }

}
