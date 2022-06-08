package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Binder;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.Fragments.MatchesFragment;
import com.example.helloworld.Fragments.ProfileFragment;
import com.example.helloworld.Fragments.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.lib.OnItemReselectedListener;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class DashboardActivity extends AppCompatActivity {

    SmoothBottomBar smoothBottomBar;

    private List<Fragment> mFragmentList = new ArrayList<>();
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        String full_name = getIntent().getExtras().getString("full_name");
        String email_addr = getIntent().getExtras().getString("email_addr");
        String bio = getIntent().getExtras().getString("bio");
        String user_name = getIntent().getExtras().getString("user_name");
        String age = getIntent().getExtras().getString("age");
        String occupation = getIntent().getExtras().getString("occupation");
        String mobile = getIntent().getExtras().getString("mobile");



        smoothBottomBar = findViewById(R.id.bottomBar);
        viewPager = findViewById(R.id.view_pager);



        ProfileFragment profileFragment = new ProfileFragment();
        Bundle data = new Bundle();
        data.putString("full_name", full_name);
        data.putString("email_addr", email_addr);
        data.putString("bio", bio);
        data.putString("user_name", user_name);
        data.putString("age", age);
        data.putString("occupation", occupation);
        data.putString("mobile", mobile);
        profileFragment.setArguments(data);


        mFragmentList.add(profileFragment);
        mFragmentList.add(new MatchesFragment());
        mFragmentList.add(new SettingsFragment());


        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        };

        viewPager.setAdapter(adapter);


        // Attach the page change listener inside the activity
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        smoothBottomBar.setItemActiveIndex(0);
                        break;
                    case 1:
                        smoothBottomBar.setItemActiveIndex(1);
                        break;
                    case 2:
                        smoothBottomBar.setItemActiveIndex(2);
                        break;
                }
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(0);






        smoothBottomBar.setSelected(true);
        smoothBottomBar.setItemActiveIndex(0);

        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                viewPager.setCurrentItem(i);

                return false;
            }
        });
        
    }
}