package com.example.digitalparenting;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private Button dashboard;
    private Button button1;
    private Button button6;
    private Button btnMother;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        button1 = findViewById(R.id.TrackingPregnancy);
        button6 = findViewById(R.id.ActivitySix);
        dashboard = (Button) findViewById(R.id.button);
        btnMother = findViewById(R.id.btnMother);

        btnMother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Mother.class);
                startActivity(intent);
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActivityOne.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ActivitySix.class);
                startActivity(intent);

            }
        });


        getMainData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    private void getMainData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("Content");


        //home
        DatabaseReference home = myRef.child("home");

        //expectant
        DatabaseReference  childBirth  =  myRef.child("Expectant").child("childbirth");
        DatabaseReference  sixnine  =  myRef.child("Expectant").child("sixnine");

        //postpo
        DatabaseReference  onetwo  =  myRef.child("postpartum").child("onetotwo");





        onetwo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                AppData value = dataSnapshot.getValue(AppData.class);
                //set details
                if (value != null) {
                    TextView tv = findViewById(R.id.welcome_paragraph);
                    tv.setText(value.getContent());
                    Log.e("Data",value.content);

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }

}




