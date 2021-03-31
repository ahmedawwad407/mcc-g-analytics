package com.example.googleanaassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ElectronicProduct extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    Button lapLenovo;
    Button phoneApple;
    Button lapHP;
    Button lapApple;
    Button phoneSamsung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic_product);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        selectContent("E4", "FourEvent", "Image4");
        xEvent("X4", "x4Event");
        trackScreen("ElectronicProduct");

        lapLenovo = findViewById(R.id.Lap_Lenovo);
        phoneApple = findViewById(R.id.Phone_Apple);
        lapHP = findViewById(R.id.Lap_HP);
        lapApple = findViewById(R.id.Lap_Apple);
        phoneSamsung = findViewById(R.id.Phone_Samsung);

        lapLenovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), lapLenovoScreen.class);
                startActivity(i);
            }
        });
        phoneApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), phoneAppleScreen.class);
                startActivity(i);
            }
        });
        lapHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), lapHPScreen.class);
                startActivity(i);
            }
        });
        lapApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LapAppleScreen.class);
                startActivity(i);
            }
        });
        phoneSamsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PhoneSamsungScreen.class);
                startActivity(i);
            }
        });
    }

    //recommendedEvents
    private void selectContent(String id, String name, String contentType) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    ///customEvent
    private void xEvent(String id, String name) {
        Bundle xEventBundle = new Bundle();
        xEventBundle.putString("id", id);
        xEventBundle.putString("name", name);
        mFirebaseAnalytics.logEvent("X_Event", xEventBundle);
    }

    private void trackScreen(String screenName) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "ElectronicProduct");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }
}