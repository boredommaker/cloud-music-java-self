package com.example.cloud_music_java_self.component.main.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.cloud_music_java_self.adapter.BaseFragmentStatePagerAdapter;
import com.example.cloud_music_java_self.component.discovery.fragment.DiscoveryFragment;
import com.example.cloud_music_java_self.component.feed.fragment.FeedFragment;
import com.example.cloud_music_java_self.component.me.fragment.MeFragment;
import com.example.cloud_music_java_self.component.room.fragment.RoomFragment;
import com.example.cloud_music_java_self.component.video.fragment.VideoFragment;

/**
 * 主界面ViewPager的Adapter
 */
public class MainAdapter extends BaseFragmentStatePagerAdapter<Integer> {
    /***
     *  @param context 上下文
     * @param fm Fragment管理器
     */
    public MainAdapter(Context context, @NonNull FragmentManager fm) {
        super(context, fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return VideoFragment.newInstance();
            case 2:
                return MeFragment.newInstance();
            case 3:
                return FeedFragment.newInstance();
            case 4:
                return RoomFragment.newInstance();
            default:
                return DiscoveryFragment.newInstance();
        }
    }
}
