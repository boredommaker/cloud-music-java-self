package com.example.cloud_music_java_self;

import android.content.Intent;

import com.example.cloud_music_java_self.activity.BaseViewModelActivity;
import com.example.cloud_music_java_self.component.login.activity.LoginHomeActivity;
import com.example.cloud_music_java_self.component.main.TabEntity;
import com.example.cloud_music_java_self.databinding.ActivityMainBinding;
import com.example.cloud_music_java_self.util.Constant;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;

/**
 * 主界面
 */
public class MainActivity extends BaseViewModelActivity<ActivityMainBinding> {
    /**
     * 底部指示器（tab）文本，图标，选中的图标
     */
    private static final int[] indicatorTitles = new int[]{R.string.discovery, R.string.video, R.string.me, R.string.feed, R.string.live};
    private static final int[] indicatorIcons = new int[]{R.drawable.discovery, R.drawable.video, R.drawable.me, R.drawable.feed, R.drawable.live};
    private static final int[] indicatorSelectedIcons = new int[]{R.drawable.discovery_selected, R.drawable.video_selected, R.drawable.me_selected, R.drawable.feed_selected, R.drawable.live_selected};
//    private MainAdapter adapter;

    @Override
    protected void initViews() {
        super.initViews();
        //状态栏透明，内容显示到状态栏
        QMUIStatusBarHelper.translucent(this);

        //缓存页面数量
        // 默认是缓存一个
        binding.list.setOffscreenPageLimit(5);

        //指示器
        ArrayList<CustomTabEntity> indicatorTabs = new ArrayList<>();
        for (int i = 0; i < indicatorTitles.length; i++) {
            indicatorTabs.add(
                    new TabEntity(
                            getString(indicatorTitles[i]),
                            indicatorSelectedIcons[i],
                            indicatorIcons[i]
                    )
            );
        }
        binding.indicator.setTabData(indicatorTabs);

        //动态tab显示消息提醒
        binding.indicator.showDot(2);
        binding.indicator.showDot(3);
    }

    @Override
    protected void initDatum() {
        super.initDatum();

//        adapter = new MainAdapter(getHostActivity(), getSupportFragmentManager());
//        binding.list.setAdapter(adapter);
//
//        adapter.setDatum(Arrays.asList(0, 1, 2, 3, 4, 5));

        String action = getIntent().getAction();
        if (Constant.ACTION_LOGIN.equals(action)) {
            //跳转到启动界面
            startActivity(LoginHomeActivity.class);
        }
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        //设置指示器切换监听器
//        binding.indicator.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                binding.list.setCurrentItem(position);
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });
//

//        binding.list.addOnPageChangeListener(new OnPageChangeListenerAdapter() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                binding.indicator.setCurrentTab(position);
//            }
//        });
    }
}