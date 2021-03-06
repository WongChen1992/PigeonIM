package com.pixel.pigeonim.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.pixel.pigeonim.R;
import com.pixel.pigeonim.adapter.TabViewPagerAdapter;
import com.pixel.pigeonim.fragment.ContactsFragment;
import com.pixel.pigeonim.fragment.ConversationFragment;
import com.pixel.pigeonim.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabTitles = new ArrayList<>();


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        setSupportActionBar(toolbar);
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorTabNormalColor), getResources().getColor(R.color.colorTabSelectedColor));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTabSelectedColor));

        ConversationFragment conversationFragment = new ConversationFragment();
        ContactsFragment contactsFragment = new ContactsFragment();
        MineFragment mineFragment = new MineFragment();
        fragments.add(conversationFragment);
        fragments.add(contactsFragment);
        fragments.add(mineFragment);

        tabTitles.add("会话");
        tabTitles.add("联络人");
        tabTitles.add("我的");

        viewPager.setAdapter(new TabViewPagerAdapter(getSupportFragmentManager(), tabTitles, fragments));
        viewPager.setOffscreenPageLimit(viewPager.getChildCount());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                fragments.get(position).onResume();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                //TODO
//                Intent intent = new Intent();
//                intent.setClass(this, SettingsActivity.class);
//                startActivity(intent);
                Log.e("====", "setting");
                startActivity(SettingActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
