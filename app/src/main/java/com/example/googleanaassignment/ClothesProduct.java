package com.example.googleanaassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class ClothesProduct extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    Button jacket;
    Button shoes;
    Button shirt;
    Button pants;
    Button coat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_product);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        selectContent("E3", "ThirdEvent", "Image3");
        xEvent("X3", "x3Event");
        trackScreen("ClothesProduct");

        jacket =findViewById(R.id.Jacket);
        shoes =findViewById(R.id.shoes);
        shirt =findViewById(R.id.Shirt);
        pants =findViewById(R.id.Pants);
        coat =findViewById(R.id.Coat);

        jacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),JacketScreen.class);
                startActivity(i);
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),ShoesScreen.class);
                startActivity(i);
            }
        });
        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),ShirtScreen.class);
                startActivity(i);
            }
        });
        pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),PantsScreen.class);
                startActivity(i);
            }
        });
        coat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),CoatScreen.class);
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
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "ClothesProduct");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }
}