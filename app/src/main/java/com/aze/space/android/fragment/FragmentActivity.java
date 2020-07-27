package com.aze.space.android.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.aze.learnandroid.R;

public class FragmentActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_async_task);

    }
}
