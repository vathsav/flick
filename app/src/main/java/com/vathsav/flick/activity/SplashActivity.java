package com.vathsav.flick.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.vathsav.flick.R;
import com.vathsav.flick.utils.Constants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseApp.initializeApp(getApplicationContext());

        setContentView(R.layout.activity_splash);

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2500);

                    FirebaseAuth.getInstance().addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                        @Override
                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                            if (firebaseAuth.getCurrentUser() != null) {
                                // User is logged in
                                startActivity(Constants.intentMain);
                            } else {
                                // user is logged out
                                startActivity(Constants.intentLogin);
                            }
                        }
                    });

                    finish();
                } catch (Exception ex) {
                    Log.e(Constants.LOG_CATCH_EXCEPTION_VERBOSE, ex.getMessage());
                } finally {
                    finish();
                }
            }
        }.start();
    }
}
