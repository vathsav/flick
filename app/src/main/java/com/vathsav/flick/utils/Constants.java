package com.vathsav.flick.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vathsav.flick.BuildConfig;

/**
 * Created by vathsav on 31/05/16.
 * General app wide constants
 */
public class Constants {

    // Log tags
    public static final String LOG_CATCH_EXCEPTION_VERBOSE = "Catch: ";
    public static final String LOG_FIREBASE_MESSAGING_VERBOSE = "Messaging Service: ";

    // Sign in modes
    public static final String SIGN_IN_USING_EMAIL = "signInUsingGoogle";
    public static final String SIGN_IN_USING_GOOGLE = "signInUsingFacebook";
    public static final String SIGN_IN_USING_FACEBOOK = "signInUsingEmail";

    // Request codes
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
    public static final String intentNewConversation = "com.vathsav.flick.NEW_CONVERSATION";

    // Firebase references
    public static final DatabaseReference firebaseReferenceUsers = FirebaseDatabase.getInstance().getReference("users");
    public static final DatabaseReference firebaseReferenceConversations = FirebaseDatabase.getInstance().getReference("conversations");

    // Miscellaneous
    public static final String userName = "Joker";
    public String firebaseUrl = BuildConfig.FIREBASE_URL;
}
