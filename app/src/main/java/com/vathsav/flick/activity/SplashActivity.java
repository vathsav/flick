package com.vathsav.flick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vathsav.flick.R;
import com.vathsav.flick.utils.Constants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button setName = (Button) findViewById(R.id.button_set_name);
        final EditText username = (EditText) findViewById(R.id.edit_text_name);

        if (setName != null && username != null) {
            setName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Constants.userName = username.getText().toString();
                    Intent openMainActivity = new Intent("com.vathsav.flick.MAIN");
                    startActivity(openMainActivity);
                }
            });
        }

        /*
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                    Intent openMainActivity = new Intent("com.vathsav.flick.MAIN");
                    startActivity(openMainActivity);
                } catch (Exception ex) {
                    Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, ex.getMessage());
                } finally {
                    finish();
                }
            }
        }.start();
        */
    }
}
