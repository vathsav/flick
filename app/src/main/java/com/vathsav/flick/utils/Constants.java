package com.vathsav.flick.utils;

import android.content.Intent;

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

    // Intents
    public static final Intent intentLogin = new Intent("com.vathsav.flick.LOGIN");
    public static final Intent intentWalkthrough = new Intent("com.vathsav.flick.WALKTHROUGH");
    public static final Intent intentMain = new Intent("com.vathsav.flick.MAIN");
    public static final Intent intentNewConveration = new Intent("com.vathsav.flick.NEW_CONVERSATION");
    public static final Intent intentThread = new Intent("com.vathsav.flick.THREAD");
    public static final Intent intentFeedback = new Intent("com.vathsav.flick.FEEDBACK");
    public static final Intent intentAbout = new Intent("com.vathsav.flick.ABOUT");
    public static final Intent intentSettings = new Intent("com.vathsav.flick.SETTINGS");

    // Firebase references
    public static final DatabaseReference firebaseReferenceUsers = FirebaseDatabase.getInstance().getReference("users");
    public static final DatabaseReference firebaseReferenceConversations = FirebaseDatabase.getInstance().getReference("conversations");

    // Miscellaneous
    public static final String userName = "Joker";
    public String firebaseUrl = BuildConfig.FIREBASE_URL;
}
