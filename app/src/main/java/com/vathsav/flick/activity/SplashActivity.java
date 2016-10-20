package com.vathsav.flick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vathsav.flick.R;
import com.vathsav.flick.utils.Constants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent openMainActivity = Constants.intentMain;
                    Intent openLoginActivty = Constants.intentLogin;
                    startActivity(openLoginActivty);
                } catch (Exception ex) {
                    Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, ex.getMessage());
                } finally {
                    finish();
                }
            }
        }.start();
    }
}
