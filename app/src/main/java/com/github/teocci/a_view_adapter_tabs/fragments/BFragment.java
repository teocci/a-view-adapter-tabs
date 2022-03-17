package com.github.teocci.a_view_adapter_tabs.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.teocci.a_view_adapter_tabs.R;
import com.github.teocci.a_view_adapter_tabs.interfaces.FragmentEventHandler;

public class BFragment extends Fragment {
    private static final String TAG = "BF";
    public static final int DEFAULT_VALUE = 0;

    private int value;

    private boolean viewCreated = false;

    private TextView tvValue;

    private FragmentEventHandler eventHandler;

    public static BFragment newInstance(FragmentEventHandler eventHandler) {
        return new BFragment(eventHandler);
    }

    public BFragment(FragmentEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);
        TextView fragmentListTitle = (TextView) rootView.findViewById(R.id.text_view_title);
        fragmentListTitle.setText(getResources().getString(R.string.fragment_title_b));

        tvValue = (TextView) rootView.findViewById(R.id.text_view_value);
        updateValue();
        updateView();

        if (eventHandler != null) eventHandler.onViewCreated(this);
        viewCreated = true;

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView()");
    }

    public void setEventHandler(FragmentEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public boolean isViewCreated() {
        return viewCreated;
    }

    public void updateValue() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.value = bundle.getInt("TEST_VALUE", DEFAULT_VALUE);
        }
    }

    public void updateView() {
        updateValue();

        String val = "" + value;
        if (tvValue != null) tvValue.setText(val);
        Log.d(TAG, val);
    }
}
