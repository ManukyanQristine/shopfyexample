package com.shopify.task.activities;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.shopify.task.R;
import com.shopify.task.adapters.ViewPagerAdapter;
import com.shopify.task.fragments.ProductsFragment;
import com.shopify.task.fragments.FavoriteProductsFragment;
import com.shopify.task.helpers.InternetConnectionReceiver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private ViewPagerAdapter adapter;
    private InternetConnectionReceiver connectionReceiver;

    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        connectionReceiver = new InternetConnectionReceiver();
        registerReceiver(connectionReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        fragmentList = new ArrayList<>();
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        addSlide(ProductsFragment.newInstance(), getString(R.string.products));
        addSlide(FavoriteProductsFragment.newInstance(), getString(R.string.favorite_products));


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void addSlide(Fragment fragment, String tabName) {
        tabLayout.addTab(tabLayout.newTab().setText(tabName));
        fragmentList.add(fragment);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connectionReceiver != null)
            unregisterReceiver(connectionReceiver);
    }
}
