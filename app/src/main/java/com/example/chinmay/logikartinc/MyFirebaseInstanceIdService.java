package com.example.chinmay.logikartinc;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by chinmay on 16/9/17.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static  final String REG_TOKEN = "REG_TOKEN";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String recent_token = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recent_token);
    }
}