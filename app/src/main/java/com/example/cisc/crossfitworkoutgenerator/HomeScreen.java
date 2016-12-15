package com.example.cisc.crossfitworkoutgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    //Animation wobble = AnimationUtils.loadAnimation(this, R.anim.wobble);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button gallery_button = (Button) findViewById(R.id.gallery_button);
        gallery_button.setOnClickListener(this);

        Button generate_workout = (Button) findViewById(R.id.generate_workout);
        generate_workout.setOnClickListener(this);

        Button options_menu = (Button) findViewById(R.id.options_menu);
        options_menu.setOnClickListener(this);

        Button send_feedback = (Button) findViewById(R.id.send_feedback);
        send_feedback.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gallery_button:
                Intent i;
                i = new Intent(this, Gallery.class);
                startActivity(i);
                break;

            case R.id.generate_workout:
                Toast.makeText(HomeScreen.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.options_menu:
                i = new Intent(this, OptionsMenu.class);
                startActivity(i);
                break;

            case R.id.send_feedback:
                i = new Intent(this, SendFeedback.class);
                startActivity(i);
                break;
        }
    }
}
