package com.github.teocci.a_view_adapter_tabs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.github.teocci.a_view_adapter_tabs.R;

public class CFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_c, container, false);
        TextView fragmentListTitle = (TextView) rootView.findViewById(R.id.text_view_title);
        fragmentListTitle.setText(getResources().getString(R.string.fragment_title_c));

        return rootView;
    }
}
