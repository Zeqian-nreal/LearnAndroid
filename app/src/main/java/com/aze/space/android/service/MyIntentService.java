package com.aze.space.android.service;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {
    private  static  final  String Tag = "MyIntentService";

    public MyIntentService() {
        super(Tag);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
