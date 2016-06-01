package com.vathsav.flick.service;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.vathsav.flick.utils.Constants;

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(Constants.LOG_FIREBASE_MESSAGING_VERBOSE, "From: " + remoteMessage.getFrom());
        Log.d(Constants.LOG_FIREBASE_MESSAGING_VERBOSE, "Notification Message Body: " + remoteMessage.getNotification().getBody());
    }
}
