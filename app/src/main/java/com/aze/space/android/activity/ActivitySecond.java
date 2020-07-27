package com.aze.space.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aze.learnandroid.R;

public class ActivitySecond extends Activity {
    private static final String TAG = "Activity Two";
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        btnStart = (Button) findViewById(R.id.btn_finish);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ActivitySecond.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "****onStart****");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "****onPause****");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "****onResume****");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "****onStop****");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "****onDestroy****");
        super.onDestroy();
    }
}
