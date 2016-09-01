package com.vathsav.flick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vathsav.flick.BuildConfig;
import com.vathsav.flick.utils.Constants;

/**
 * Created by vathsav on 01/06/16.
 * Base activity with authentication variables that can be extended by other activities
 */
public class BaseActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener {

    protected GoogleApiClient googleApiClient;
    protected FirebaseAuth firebaseAuth;
    protected FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    protected boolean point = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.FLICK_OAUTH_CLIENT_ID)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
//
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    // User is signed in
                    startActivity(new Intent(Constants.intentMain));
                    finish();
                    Toast.makeText(getApplicationContext(), "User signed in", Toast.LENGTH_SHORT).show();

                } else {
                    // User isn't signed in
                    Toast.makeText(getApplicationContext(), "User wasn't signed in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Constants.intentMain));
                    finish();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (point)
            firebaseAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (point)
            if (firebaseAuth != null)
                firebaseAuth.removeAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
