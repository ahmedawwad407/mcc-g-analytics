package com.example.googleanaassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class FoodProduct extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    Button fish;
    Button shawarma;
    Button chickens;
    Button kebab;
    Button meat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_product);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        selectContent("E2", "SecEvent", "Image2");
        xEvent("X2", "x2Event");
        trackScreen("FoodProduct");

        fish =findViewById(R.id.fish);
        shawarma =findViewById(R.id.Shawarma);
        chickens =findViewById(R.id.chickens);
        kebab =findViewById(R.id.kebab);
        meat =findViewById(R.id.Meat);

        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),FishScreen.class);
                startActivity(i);
            }
        });
        shawarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),ShawarmaScreen.class);
                startActivity(i);
            }
        });
        chickens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),ChickensScreen.class);
                startActivity(i);
            }
        });
        kebab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),KebabScreen.class);
                startActivity(i);
            }
        });
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MeatScreen.class);
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
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "FoodProduct");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }
}