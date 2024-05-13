package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    // default selected
    private var selectedTab = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeGroup: LinearLayout = findViewById(R.id.home_group)
        val myRidesGroup: LinearLayout = findViewById(R.id.myrides_group)
        val chatsGroup: LinearLayout = findViewById(R.id.chats_group)
        val profileGroup: LinearLayout = findViewById(R.id.profile_group)

        val homeImage: ImageView = findViewById(R.id.home_image)
        val ridesImage: ImageView = findViewById(R.id.rides_image)
        val chatsImage: ImageView = findViewById(R.id.chats_image)
        val profileImage: ImageView = findViewById(R.id.profile_image)

        val homeTxt: TextView = findViewById(R.id.home_txt)
        val ridesTxt: TextView = findViewById(R.id.rides_txt)
        val chatsTxt: TextView = findViewById(R.id.chats_txt)
        val profileTxt: TextView = findViewById(R.id.profile_txt)

        //By default Home fragment
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, HomeFragment(), null)
            .commit()

//Selection of icons
        homeGroup.setOnClickListener {
            if (selectedTab != 1) {
                //set Home
                supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, HomeFragment(), null)
                    .commit()
                // Unselect all others
                ridesTxt.visibility = View.GONE
                chatsTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                ridesImage.setImageResource(R.drawable.vector)
                chatsImage.setImageResource(R.drawable.communication)
                profileImage.setImageResource(R.drawable.group115)

                myRidesGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                chatsGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                profileGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))

                // Select Home tab
                homeTxt.visibility = View.VISIBLE
                homeImage.setImageResource(R.drawable.group114)
                homeGroup.setBackgroundResource(R.drawable.oval_bg_hover)

                // Animation
                val scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f)
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                homeGroup.startAnimation(scaleAnimation)

                selectedTab = 1
            }
        }

        myRidesGroup.setOnClickListener {
            //set Rides
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, MyRidesFragment(), null)
                .commit()
            //Visibility
            if (selectedTab != 2) {
                // Unselect all others
                homeTxt.visibility = View.GONE
                chatsTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                homeImage.setImageResource(R.drawable.group114)
                chatsImage.setImageResource(R.drawable.communication)
                profileImage.setImageResource(R.drawable.group115)

                homeGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                chatsGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                profileGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))

                // Select My Rides tab
                ridesTxt.visibility = View.VISIBLE
                ridesImage.setImageResource(R.drawable.vector)
                myRidesGroup.setBackgroundResource(R.drawable.oval_bg_hover)

                // Animation
                val scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f)
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                myRidesGroup.startAnimation(scaleAnimation)

                selectedTab = 2
            }
        }

        chatsGroup.setOnClickListener {
            //Chats Fragment
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, ChatsFragment(), null)
                .commit()
            //visibility
            if (selectedTab != 3) {
                // Unselect all others
                ridesTxt.visibility = View.GONE
                homeTxt.visibility = View.GONE
                profileTxt.visibility = View.GONE

                ridesImage.setImageResource(R.drawable.vector)
                homeImage.setImageResource(R.drawable.group114)
                profileImage.setImageResource(R.drawable.group115)

                myRidesGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                homeGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                profileGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))

                // Select Chats tab
                chatsTxt.visibility = View.VISIBLE
                chatsImage.setImageResource(R.drawable.communication)
                chatsGroup.setBackgroundResource(R.drawable.oval_bg_hover)

                // Animation
                val scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f)
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                chatsGroup.startAnimation(scaleAnimation)

                selectedTab = 3
            }
        }

        profileGroup.setOnClickListener {
            //profile Fragment
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, ProfileFragment(), null)
                .commit()
            //visibility
            if (selectedTab != 4) {
                // Unselect all others
                ridesTxt.visibility = View.GONE
                chatsTxt.visibility = View.GONE
                homeTxt.visibility = View.GONE

                ridesImage.setImageResource(R.drawable.vector)
                chatsImage.setImageResource(R.drawable.communication)
                homeImage.setImageResource(R.drawable.group114)

                myRidesGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))

                chatsGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                homeGroup.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))

                // Select Profile tab
                profileTxt.visibility = View.VISIBLE
                profileImage.setImageResource(R.drawable.group115)
                profileGroup.setBackgroundResource(R.drawable.oval_bg_hover)

                // Animation
                val scaleAnimation = ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f)
                scaleAnimation.duration = 200
                scaleAnimation.fillAfter = true
                profileGroup.startAnimation(scaleAnimation)

                selectedTab = 4
            }
        }
    }
}
