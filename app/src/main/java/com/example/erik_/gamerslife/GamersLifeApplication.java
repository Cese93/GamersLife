package com.example.erik_.gamerslife;

import android.app.Application;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import es.dmoral.toasty.Toasty;

public class GamersLifeApplication extends Application {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private StorageReference mStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        /*CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/montserrat.regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );*/
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mStorage = FirebaseStorage.getInstance().getReference();

    }

    public FirebaseAuth getAuthInstance() {
        return FirebaseAuth.getInstance();
    }

    public DatabaseReference getDatabaseReference() {
        return mDatabase;
    }

    public StorageReference getStorageReference() {
        return mStorage;
    }

    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }
}
