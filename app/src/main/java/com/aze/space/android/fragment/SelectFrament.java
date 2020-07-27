package com.aze.space.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aze.learnandroid.R;

public class SelectFrament extends Fragment {
    private static final String TAG ="SelectFrament" ;

    public interface Callback{
        void onItemSelected(int id);
    }

    private  Callback mListener;
    private  ListView listView;

    public SelectFrament(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        final  String[] names = {"Hi","Hello","World"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1,names);
        View view = inflater.inflate(R.layout.fragment_select,container,false);
        listView = (ListView)view.findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mListener != null){
                    mListener.onItemSelected(position);
                }
            }
        });
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach");
        super.onAttach(context);
        if (context instanceof Callback){
            mListener = (Callback)context;
        }else{
            throw new RuntimeException(context.toString()+ " must implement Callback");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListener.onItemSelected(0);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
