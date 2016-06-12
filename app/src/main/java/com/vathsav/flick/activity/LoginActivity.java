package com.vathsav.flick.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.InterpolatorRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.GoogleAuthProvider;
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
                    if (!signIn(Constants.SIGN_IN_USING_GOOGLE))
                        Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, "Error Signing In");
                }
            });

        if (takeMeIn != null) {
            takeMeIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    if (!signIn(Constants.SIGN_IN_USING_EMAIL))
                    Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, "Error Signing In");
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE_SIGN_IN_GOOGLE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                authenticateUsingGoogle(account);
            } else {
                Log.v(Constants.LOG_CATCH_EXCEPTION_VERBOSE, "Error Signing In");
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
                point = true;
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent, Constants.REQUEST_CODE_SIGN_IN_GOOGLE);
                break;
            case Constants.SIGN_IN_USING_FACEBOOK:
                return true;
        }
        return false;
    }

    private void authenticateUsingGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TAG", "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("TAG", "signInWithCredential", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }
}
