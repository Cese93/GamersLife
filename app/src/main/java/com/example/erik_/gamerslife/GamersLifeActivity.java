package com.example.erik_.gamerslife;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class GamersLifeActivity extends AppCompatActivity {

    public GamersLifeApplication getMyApplication() {
        return (GamersLifeApplication) getApplication();
    }

    public void showErrorToast(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }

}
