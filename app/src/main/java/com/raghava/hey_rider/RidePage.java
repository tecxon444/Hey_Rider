package com.raghava.hey_rider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class RidePage extends NavBar {

    LinearLayout navBar, dynamicContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dynamicContent = (LinearLayout) findViewById(R.id.dynamic_content);
        navBar = (LinearLayout) findViewById(R.id.nav_bar_layout);

        View wizard = LayoutInflater.from(this).inflate(R.layout.activity_ride_page, null);
        dynamicContent.addView(wizard);

        navBar.getChildAt(0).setSelected(false);
        navBar.getChildAt(1).setSelected(true);
    }

}