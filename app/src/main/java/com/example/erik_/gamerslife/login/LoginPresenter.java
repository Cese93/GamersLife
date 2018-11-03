package com.example.erik_.gamerslife.login;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.erik_.gamerslife.GamersLifeApplication;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.dmoral.toasty.Toasty;

public class LoginPresenter extends GamersLifeApplication {
private Activity activity;

    private LoginView view;

    private Uri resultUri;

    public LoginPresenter(LoginView view, Activity activity){
        this.view = view;
        this.activity = activity;
    }

    public void createAccount(String email, String password){
        getAuthInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = getCurrentUser();
                        } else {
                            view.notifyLogin(task.getException().getMessage());
                            //Toasty.error(activity, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void login(String email, String password){
        getAuthInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = getAuthInstance().getCurrentUser();
                        } else {
                           view.notifyLogin(task.getException().getMessage());
                        }
                    }
                });
    }

    /*public void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) getBaseContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            view.startHomeActivity();
                        } else {
                            showErrorToast(task.getException().getMessage());
                        }

                    }
                });
    }*/

   /* public void createAccount(final String username, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) getBaseContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                            final String currentUserId = currentUser.getUid();
                            HashMap<String, String> userMap = new HashMap<>();
                            userMap.put("username", username);
                            userMap.put("image", "null");
                            //Aggiunge l'username al currentUser
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(username)
                                    .build();
                            currentUser.updateProfile(profileUpdates);

                            mDatabase.child("users").child(currentUserId).setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    StorageReference filepath = mStorage.child("profile_images").child(currentUserId + ".jpg");
                                    if (resultUri != null) {
                                        filepath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                                if (task.isSuccessful()) {
                                                    @SuppressWarnings("VisibleForTests") Uri downloadUrl = task.getResult().getUploadSessionUri();
                                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                            .setDisplayName(username.toString())
                                                            .setPhotoUri(downloadUrl)
                                                            .build();
                                                    currentUser.updateProfile(profileUpdates);
                                                    mDatabase.child("users").child(currentUserId).child("image").setValue(downloadUrl.toString());

                                                } else {
                                                    showErrorToast("Error in uploading");
                                                }
                                            }
                                        });
                                    }
                                }
                            });

                            view.restartLoginActivity();
                        } else {
                            showErrorToast(task.getException().getMessage());
                        }

                    }
                });
    }*/
}
