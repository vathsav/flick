package com.vathsav.flick.utils;

import com.vathsav.flick.BuildConfig;

/**
 * Created by vathsav on 31/05/16.
 * General app wide constants
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

    // Intents
    public static final String intentLogin = "com.vathsav.flick.LOGIN";
    public static final String intentWalkthrough = "com.vathsav.flick.WALKTHROUGH";
    public static final String intentMain = "com.vathsav.flick.MAIN";
    public static final String intentThread = "com.vathsav.flick.THREAD";
    public static final String intentFeedback = "com.vathsav.flick.FEEDBACK";
    public static final String intentAbout = "com.vathsav.flick.ABOUT";
    public static final String intentSettings = "com.vathsav.flick.SETTINGS";

    // Miscellaneous
    public static String userName = "Joker";
    public String firebaseUrl = BuildConfig.FIREBASE_URL;
}
