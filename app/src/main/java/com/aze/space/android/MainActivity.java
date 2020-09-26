package com.aze.space.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.util.LruCache;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


import com.aze.learnandroid.BuildConfig;
import com.aze.learnandroid.R;

//import java.util.Map;

public class MainActivity extends Activity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate buildTime:" + BuildConfig.BUILD_TIME);
        setContentView(R.layout.main_activity);

        ((Button) findViewById(R.id.btn_activity1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("fragment.FragmentActivit");
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.btn_activity2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.handler.HandlerActivity");
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.btn_activity3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("lesson.AsyncTaskActivity");
                startActivity(intent);
            }
        });


//        mLrucache = new LruCache<String,Integer>(3);
//
//        mLrucache.put("hello1",new Integer(1));
//        mLrucache.put("hello2",new Integer(2));
//        mLrucache.put("hello3",new Integer(3));
//        mLrucache.put("hello4",new Integer(4));
//        mLrucache.put("hello3",new Integer(3));
//
//
//        for (Map.Entry<String, Integer> entry : mLrucache.snapshot().entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    //    private LruCache<String,Integer> mLrucache;
}
