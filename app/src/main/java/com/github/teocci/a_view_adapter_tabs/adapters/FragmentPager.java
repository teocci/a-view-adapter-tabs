package com.github.teocci.a_view_adapter_tabs.adapters;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.github.teocci.a_view_adapter_tabs.fragments.BFragment;
import com.github.teocci.a_view_adapter_tabs.interfaces.FragmentEventHandler;

import java.util.ArrayList;
import java.util.List;

public class FragmentPager extends FragmentStateAdapter {
    private static final String TAG = "FP";

    private final List<Fragment> fragments = new ArrayList<>();

    public FragmentPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment f = getFragment(position);
        if (f == null) throw new NullPointerException();

        return f;
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public void addFragment(Fragment f) {
        fragments.add(fragments.size(), f);
        notifyItemInserted(fragments.size() - 1);
    }

    public void removeFragment() {
        fragments.remove(fragments.size() - 1);
        notifyItemRemoved(fragments.size());
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }

    public void setEventHandler(int position,FragmentEventHandler eventHandler) {
        BFragment fragment = (BFragment) getFragment(position);
        fragment.setEventHandler(eventHandler);
    }

    public void updateBValue(int position, int value) {
        BFragment fragment = (BFragment) getFragment(position);
        if (fragment == null) return;
        Log.e(TAG, "Fragment called");

        Bundle bundle = new Bundle();
        bundle.putInt("TEST_VALUE", value);
        fragment.setArguments(bundle);

        fragment.updateValue();
        Log.e(TAG, "updateValue() called");
    }
}
