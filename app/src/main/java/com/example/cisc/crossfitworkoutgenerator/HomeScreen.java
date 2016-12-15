package com.example.cisc.crossfitworkoutgenerator;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool;
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;

    Animation wobble;

    Button gallery_button;
    Button generate_workout;
    Button options_menu;
    Button send_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        wobble = AnimationUtils.loadAnimation(this, R.anim.wobble);

        gallery_button = (Button) findViewById(R.id.gallery_button);
        gallery_button.setOnClickListener(this);

        generate_workout = (Button) findViewById(R.id.generate_workout);
        generate_workout.setOnClickListener(this);

        options_menu = (Button) findViewById(R.id.options_menu);
        options_menu.setOnClickListener(this);

        send_feedback = (Button) findViewById(R.id.send_feedback);
        send_feedback.setOnClickListener(this);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);

        try{

//Create objects of the 2 required classes

            AssetManager assetManager = getAssets();

            AssetFileDescriptor descriptor;

//create our three fx in memory ready for use

            descriptor = assetManager.openFd("gallery.wav");

            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("send_feedback.wav");

            sample2 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("StartSound.wav");

            sample3 = soundPool.load(descriptor, 0);

        }catch(IOException e){

//catch exceptions here

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.gallery_button:
                soundPool.play(sample1, 1, 1, 0, 0, 1);
                Intent i;
                i = new Intent(this, Gallery.class);
                startActivity(i);
                break;

            case R.id.generate_workout:
                soundPool.play(sample2, 1, 1, 0, 0, 1);
                generate_workout.startAnimation(wobble);
                Toast.makeText(HomeScreen.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.options_menu:
                i = new Intent(this, OptionsMenu.class);
                startActivity(i);
                break;

            case R.id.send_feedback:
                soundPool.play(sample3, 1, 1, 0, 0, 1);
                i = new Intent(this, SendFeedback.class);
                startActivity(i);
                break;
        }
    }
}
