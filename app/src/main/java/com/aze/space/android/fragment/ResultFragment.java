package com.aze.space.android.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.aze.learnandroid.R;

public class ResultFragment extends Fragment {
    private static final String TAG = "ResultFragment";

    public ResultFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    public void showResult(int id) {
        Log.i(TAG, "showResult");
        int images[] = {R.drawable.hello, R.drawable.hi, R.drawable.ye};
        ImageView imageView = (ImageView) getView().findViewById(R.id.imageView);
        imageView.setImageResource(images[id]);
    }
}
