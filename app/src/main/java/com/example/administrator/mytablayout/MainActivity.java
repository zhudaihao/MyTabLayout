package com.example.administrator.mytablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String[] mTitles = {
            "热门", "iOS", "Android", "前端"
            , "后端", "设计", "工具资源"
    };

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp=findViewById(R.id.vp);
        SlidingTabLayout tl_2=findViewById(R.id.tl_2);
        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }

        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tl_2.setViewPager(vp);



    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
