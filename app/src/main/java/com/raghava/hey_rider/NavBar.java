package com.raghava.hey_rider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NavBar extends Activity {

    AppCompatButton btn_ride, btn_drive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        init_views();

        btn_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_drive.setSelected(false);
                btn_ride.setSelected(true);

//                Toast.makeText(NavBar.this, "drive selected", Toast.LENGTH_SHORT).show();

                Intent driveIntent = new Intent(NavBar.this, DrivePage.class);
                startActivity(driveIntent);
                overridePendingTransition(0,0);
            }
        });

        btn_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_drive.setSelected(true);
                btn_ride.setSelected(false);

//                Toast.makeText(NavBar.this, "ride selected", Toast.LENGTH_SHORT).show();

                Intent rideIntent = new Intent(NavBar.this, RidePage.class);
                startActivity(rideIntent);
                overridePendingTransition(0,0);
            }
        });

    }

    private void init_views() {
        btn_drive = findViewById(R.id.btn_drive);
        btn_ride = findViewById(R.id.btn_ride);
    }
}
