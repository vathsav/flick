package com.vathsav.flick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.vathsav.flick.R;
import com.vathsav.flick.utils.Constants;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        Button takeMeIn = (Button) findViewById(R.id.button_take_me_in);

        if (signInButton != null)
            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!signIn(Constants.SIGN_IN_USING_GOOGLE)) {
                        Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, "Error Signing In");
                    }
                }
            });

        if (takeMeIn != null) {
            takeMeIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!signIn(Constants.SIGN_IN_USING_EMAIL)) {
                        Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, "Error Signing In");
                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Constants.REQUEST_CODE_SIGN_IN_GOOGLE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount googleSignInAccount = result.getSignInAccount();
                if (googleSignInAccount != null) {
                    Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private boolean signIn(String signInMode) {
        switch (signInMode) {
            case Constants.SIGN_IN_USING_EMAIL:
                startActivity(new Intent("com.vathsav.flick.MAIN"));
                finish();
                return true;
            case Constants.SIGN_IN_USING_GOOGLE:
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(super.googleApiClient);
                startActivityForResult(signInIntent, Constants.REQUEST_CODE_SIGN_IN_GOOGLE);
                return true;
            case Constants.SIGN_IN_USING_FACEBOOK:
                return true;
        }
        return false;
    }
}
