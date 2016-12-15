package com.example.cisc.crossfitworkoutgenerator;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

public class OptionsMenu extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);

        //create the toggle button ref and instantiate
        ToggleButton tb = (ToggleButton)this.findViewById(R.id.toggleButton);
        //default to being available
        tb.setChecked(false);
        // attach an OnClickListener
        tb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // your click actions go here
                Log.i("onToggleClicked", "ToggleClick Event Started");
                //an AudioManager object, to change the volume settings
                AudioManager amanager;
                amanager = (AudioManager)getSystemService(AUDIO_SERVICE);

                // Is the toggle on?
                boolean on = ((ToggleButton)v).isChecked();

                if (on) {
                    Log.i("onToggleIsChecked", "ToggleClick Is On");
                    //turn ringer silent
                    amanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    Log.i("RINGER_MODE_SILENT", "Set to true");

                    //turn off sound, disable notifications
                    amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
                    Log.i("STREAM_SYSTEM", "Set to true");
                    //notifications
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                    Log.i("STREAM_NOTIFICATION", "Set to true");
                    //alarm
                    amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
                    Log.i("STREAM_ALARM", "Set to true");
                    //ringer
                    amanager.setStreamMute(AudioManager.STREAM_RING, true);
                    Log.i("STREAM_RING", "Set to true");
                    //media
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                    Log.i("STREAM_MUSIC", "Set to true");

                } else {
                    Log.i("onToggleIsChecked", "ToggleClick Is Off");

                    //turn ringer silent
                    amanager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    Log.i(".RINGER_MODE_NORMAL", "Set to true");

                    // turn on sound, enable notifications
                    amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
                    Log.i("STREAM_SYSTEM", "Set to False");
                    //notifications
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    Log.i("STREAM_NOTIFICATION", "Set to False");
                    //alarm
                    amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
                    Log.i("STREAM_ALARM", "Set to False");
                    //ringer
                    amanager.setStreamMute(AudioManager.STREAM_RING, false);
                    Log.i("STREAM_RING", "Set to False");
                    //media
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                    Log.i("STREAM_MUSIC", "Set to False");
                }
                Log.i("onToggleClicked", "ToggleClick Event Ended");
            }
        });
    }
}

