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

    public void onReceive(Context context, Intent intent) {
        int id = intent.getIntExtra("id", 1);
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (day == Calendar.MONDAY || day == Calendar.WEDNESDAY || day == Calendar.FRIDAY) {
            if (id == 1 || id == 5 || id == 7) {
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            } else if (id == 2 || id == 6 || id == 8)
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        }

        if (day == Calendar.TUESDAY || day == Calendar.THURSDAY) {
            if (id == 3) {
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            } else if (id == 4)
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        }
/*
        AudioManager am;
        am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        switch (am.getRingerMode()) {
            case AudioManager.RINGER_MODE_NORMAL:
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                break;
            case AudioManager.RINGER_MODE_SILENT:
            case AudioManager.RINGER_MODE_VIBRATE:
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                break;
        }*/
    }

}
