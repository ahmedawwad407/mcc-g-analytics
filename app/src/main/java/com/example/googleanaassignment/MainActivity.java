package com.example.googleanaassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    Button food;
    Button clothes;
    Button electronic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        selectContent("E1", "FirstEvent", "Image");
        xEvent("X1", "xEvent");
        trackScreen("mainScreen");

        food = findViewById(R.id.Food);
        clothes = findViewById(R.id.Clothes);
        electronic = findViewById(R.id.Electronic);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FoodProduct.class);
                startActivity(i);
            }
        });
        clothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ClothesProduct.class);
                startActivity(i);
            }
        });
        electronic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ElectronicProduct.class);
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
/*    private void shareImageEvent(String imageName, String shareTo) {
        Bundle bundle = new Bundle();
        bundle.putString("image_Name", imageName);
        bundle.putString("share_To", shareTo);
        mFirebaseAnalytics.logEvent("Share_image", bundle);
    }*/

    private void xEvent(String id, String name) {
        Bundle xEventBundle = new Bundle();
        xEventBundle.putString("id", id);
        xEventBundle.putString("name", name);
        mFirebaseAnalytics.logEvent("X_Event", xEventBundle);
    }

    private void trackScreen(String screenName) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }


}