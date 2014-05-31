package com.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	/**
	 * The total number of pages (tabs)
	 */
	private int totalPages;

    public ViewPagerAdapter(FragmentManager fm, int totalPages) {
        super(fm);
        this.totalPages = totalPages;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position %2) {
            case 0:
                return new WhiteFragment();
            case 1:
                return new BlackFragment();
            default:
                throw new IllegalArgumentException("The item position should be less or equal to:" + totalPages);
        }
    }

    @Override
    public int getCount() {
        return totalPages;
    }
}
