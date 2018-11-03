package com.example.erik_.gamerslife.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erik_.gamerslife.GamersLifeActivity;
import com.example.erik_.gamerslife.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends GamersLifeActivity implements LoginView {
    private LoginPresenter loginPresenter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        loginPresenter = new LoginPresenter(this, LoginActivity.this);
    }

    public void createAccountClick(View view) {

        /*new LovelyCustomDialog(LoginActivity.this)
                .setView(R.layout.signup_dialog)
                .setTopColorRes(R.color.colorPrimary)
                .setIcon(R.drawable.ic_check_white_48dp)
                //.configureView(viewConfigurator)
                .setListener(R.id.signup_button, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String username = mRegisterUsername.getText().toString().trim();
                        String email = mRegisterEmail.getText().toString().trim();
                        String password = mRegisterPassword.getText().toString().trim();
                        loginPresenter.createAccount(username, email, password);

                    }
                })
                .show();*/
    }

    public void btnLoginClick(View view) {
        EditText mUsername = (EditText) findViewById(R.id.login_email);
        EditText mPassword = (EditText) findViewById(R.id.login_password);

        mUsername.setText("erik_93@live.it");
        mPassword.setText("cesenate81");

        String email = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        loginPresenter.createAccount(email, password);
    }

    @Override
    public void startHomeActivity() {
        /*Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();*/
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = getMyApplication().getAuthInstance().getCurrentUser();
        if (currentUser != null) {

        } else {
            restartLoginActivity();
        }
    }

    @Override
    public void restartLoginActivity() {
        Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void notifyLogin(String message) {
        showErrorToast(message);
    }
}
