package com.example.erik_.gamerslife;

import android.os.Bundle;

public class MainActivity extends GamersLifeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //updateUI();

    }
}
