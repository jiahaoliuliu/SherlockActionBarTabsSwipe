package com.test;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

	private ActionBar actionBar;
	private ViewPager viewPager;
	
	/**
	 * <pre>
	 * The name of the tabs. Add and remove the array to add or remove tabs.
	 * For example, for One tab {@code
	 * private String[] tabs = {"Tab 1"}
	 * }
	 * 
	 * For two tabs {@code
	 * private String[] tabs = {"Tab 1", "Tab 2"}
	 * }
	 * 
	 * For six tabs {@code
	 * private String[] tabs = {"Tab 1", "Tab 2", "Tab 3", "Tab 4", "Tab 5", "Tab 6"}
	 * }
	 * </pre>
	 */
	private String[] tabs = {"Tab 1", "Tab 2", "Tab 3", "Tab 4", "Tab 5", "Tab 6"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setOnPageChangeListener(onPageChangeListener);
		viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), tabs.length));
		addActionBarTabs();
	}

	private ViewPager.SimpleOnPageChangeListener onPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
		@Override
		public void onPageSelected(int position) {
			super.onPageSelected(position);
			actionBar.setSelectedNavigationItem(position);
		}
	};

	private void addActionBarTabs() {
		actionBar = getSupportActionBar();
		for (String tabTitle : tabs) {
			ActionBar.Tab tab = actionBar.newTab().setText(tabTitle)
					.setTabListener(tabListener);
			actionBar.addTab(tab);
		}
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	}

	private ActionBar.TabListener tabListener = new ActionBar.TabListener() {
		@Override
		public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
			viewPager.setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
		}

		@Override
		public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
		}
	};
}
