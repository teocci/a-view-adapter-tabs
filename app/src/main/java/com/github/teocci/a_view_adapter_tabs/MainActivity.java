package com.github.teocci.a_view_adapter_tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.teocci.a_view_adapter_tabs.adapters.FragmentPager;
import com.github.teocci.a_view_adapter_tabs.fragments.AFragment;
import com.github.teocci.a_view_adapter_tabs.fragments.BFragment;
import com.github.teocci.a_view_adapter_tabs.fragments.CFragment;
import com.github.teocci.a_view_adapter_tabs.interfaces.FragmentEventHandler;
import com.github.teocci.a_view_adapter_tabs.transformers.ZoomOutPageTransformer;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MA";

    public final int B_ITEM = 1;

    private final String[] titles = new String[]{"A", "B", "C"};

    private final FragmentEventHandler eventHandler = fragment -> Log.e(TAG, "FragmentEventHandler called");

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.e(TAG, String.format("Page called is: %d", position));
            }
        });

        init();
    }

    private void init() {
        viewPager.setPageTransformer(new ZoomOutPageTransformer());

        FragmentPager pager = new FragmentPager(this);
        pager.addFragment(new AFragment());
        pager.addFragment(new BFragment(eventHandler));
        pager.addFragment(new CFragment());
        viewPager.setAdapter(pager);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(titles[position])).attach();
    }

    public void calculate(View view) {
        viewPager.setCurrentItem(B_ITEM);

        FragmentPager pager = (FragmentPager) viewPager.getAdapter();
        if (pager == null) return;
        Log.e(TAG, "Pager called");

        pager.updateBValue(B_ITEM, 1000);
    }
}