package com.example.digitalparenting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    //declaring dashboard items (cards)
    CardView cardHome;
    CardView cardChat;
    CardView cardProfile;
    CardView cardWidget;
    CardView cardSettings;
    CardView cardLogout;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //calling dashboard items by id
        cardHome = findViewById(R.id.cardHome);
        cardChat = findViewById(R.id.cardChat);
        cardProfile = findViewById(R.id.cardProfile);
        cardWidget = findViewById(R.id.cardWidget);
        cardSettings = findViewById(R.id.cardSettings);
        cardLogout = findViewById(R.id.cardLogout);
        mAuth = FirebaseAuth.getInstance();

        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Launching HomePage");
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);

            }
        });

        cardChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Get assisted here");
                Intent intent = new Intent(Dashboard.this, Assistance.class);
                startActivity(intent);
            }
        });
        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("About DPS");
                Intent intent = new Intent(Dashboard.this, AboutUs.class);
                startActivity(intent);
            }
        });
        cardWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Listing References");
                Intent intent = new Intent(Dashboard.this, References.class);
                startActivity(intent);
            }
        });
        cardSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("New Updates Underway...");
            }
        });
        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Logging out");
                mAuth.signOut();
                Intent intent = new Intent(Dashboard.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    //Toast messages on clicking of dashboard card items
    private void showToast(String message){

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}