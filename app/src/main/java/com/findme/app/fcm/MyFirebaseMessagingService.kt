package com.findme.app.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {


    val TAG = javaClass::class.java.simpleName


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        // Check if message contains a notification payload.
        if (remoteMessage?.notification != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.notification!!.body)
        }
    }

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: " + token)

    }
}