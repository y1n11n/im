package com.example.improject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.improject.ui.adapter.VpFragmentAdapter;
import com.example.improject.ui.fragment.ContactsFragment;
import com.example.improject.ui.fragment.DynamicFragment;
import com.example.improject.ui.fragment.MessageFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_top_user)
    ImageView mIvTopUser;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.navigation)
    NavigationView mNavigation;
    @BindView(R.id.drawerlayout)
    DrawerLayout mDrawerlayout;
    @BindView(R.id.tv_top_title)
    TextView mTvTopTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initView() {
        initTab();
    }

    private void initTab() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MessageFragment());
        fragments.add(new ContactsFragment());
        fragments.add(new DynamicFragment());
        VpFragmentAdapter vpFragmentAdapter = new VpFragmentAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(vpFragmentAdapter);
        mTablayout.setupWithViewPager(mVp);
        mTablayout.getTabAt(0).setText("消息").setIcon(R.drawable.tab_select_message);
        mTablayout.getTabAt(1).setText("联系人").setIcon(R.drawable.tab_select_im);
        mTablayout.getTabAt(2).setText("动态").setIcon(R.drawable.tab_select_d);
    }

    private void initListener() {
        mIvTopUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerlayout.openDrawer(mNavigation);
            }
        });
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTvTopTitle.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
