package com.alexxg.android_vap_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Vector;

public class SlidePresenterActivity extends FragmentActivity {
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        initializeSlides();
    }

    private void initializeSlides() {
        pagerAdapter = new FragmentListPagerAdapter(
                getSupportFragmentManager(), createSlideFragments());

        final ViewPager pager = (ViewPager)super.findViewById(R.id.screen_pager);
        pager.setAdapter(this.pagerAdapter);
    }

    private List<Fragment> createSlideFragments() {
        final List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(new CoverFragment());
        fragments.add(new HardwareChipFragment());
        fragments.add(new IntroductionFragment());
        fragments.add(new StepsFragment());

        fragments.add(new RegistrationFragment());
        fragments.add(new DemoOne());
        fragments.add(new DemoTwo());
        fragments.add(new DemoThree());


        fragments.add(new FinaleFragment());
        fragments.add(new BackFragment());
        return fragments;
    }


    class FragmentListPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragments;

        /**
         * @param fragmentManager
         * @param fragments
         */
        public FragmentListPagerAdapter(final FragmentManager fragmentManager, final List<Fragment> fragments) {
            super(fragmentManager);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(final int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
