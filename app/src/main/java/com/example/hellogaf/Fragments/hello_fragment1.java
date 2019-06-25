package com.example.hellogaf.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hellogaf.R;

public class hello_fragment1 extends Fragment {

    public View onCreateView(
            @Nullable LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedOnInstanceState) {
        return inflater.inflate(R.layout.sea_side, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle fragmentData = getArguments();
        if (fragmentData != null) {
            Log.d("HelloWorld", fragmentData.getString("foo"));
        }
    }
}
