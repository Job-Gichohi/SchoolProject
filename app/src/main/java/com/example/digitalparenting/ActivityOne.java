package com.example.digitalparenting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityOne extends AppCompatActivity {

    private Button FirstMonths;
    private Button TrackingPregnancy;
    private Button ChildBirth;
    private Button SecondQuarter;
    private Button ThirdQuarter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        FirstMonths = findViewById(R.id.FirstMonths);
        TrackingPregnancy = findViewById(R.id.TrackingPregnancy);
        ChildBirth = findViewById(R.id.ChildBirth);

        FirstMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityOne.this, PregFirst.class);
                startActivity(intent);

            }
        });

        SecondQuarter = findViewById(R.id.SecondQuarter);

        SecondQuarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityOne.this, PregSecond.class);
                startActivity(intent);
            }
        });

        ThirdQuarter = findViewById(R.id.FinalQuarter);

        ThirdQuarter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityOne.this, PregThird.class);
                startActivity(intent);
            }
        });

        TrackingPregnancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityOne.this, TrackingPregnancy.class);
                startActivity(intent);

            }
        });

        ChildBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityOne.this, ChildBirth.class);
                startActivity(intent);

            }
        });
    }
}