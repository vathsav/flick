package com.vathsav.flick.utils;

import com.vathsav.flick.BuildConfig;

/**
 * Created by vathsav on 31/05/16.
 */
public class Constants {

    // Log tags
    public static final String LOG_CATCH_EXCEPTION_VERBOSE = "Catch: ";
    public static final String LOG_FIREBASE_MESSAGING_VERBOSE = "Messaging Service: ";
    // Sign In Modes
    public static final String SIGN_IN_USING_EMAIL = "signInUsingGoogle";
    public static final String SIGN_IN_USING_GOOGLE = "signInUsingFacebook";
    public static final String SIGN_IN_USING_FACEBOOK = "signInUsingEmail";
    // Request Codes
    public static final int REQUEST_CODE_SIGN_IN_EMAIL = 1000;
    public static final int REQUEST_CODE_SIGN_IN_GOOGLE = 1001;
    public static final int REQUEST_CODE_SIGN_IN_FACEBOOK = 1002;


    // Name
    public static String userName = null;
    public String firebaseUrl = BuildConfig.FIREBASE_URL;
}
