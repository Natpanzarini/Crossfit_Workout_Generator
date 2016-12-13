package com.example.cisc.crossfitworkoutgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button gallery_button = (Button) findViewById(R.id.gallery_button);
        gallery_button.setOnClickListener(this);

        Button GenerateWorkout = (Button) findViewById(R.id.GenerateWorkout);
        GenerateWorkout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gallery_button:
                Intent i;
                i = new Intent(this, Gallery.class);
                startActivity(i);
                break;

            case R.id.GenerateWorkout:
                i = new Intent(this, Gallery.class);
                startActivity(i);
                break;
        }
    }
}
