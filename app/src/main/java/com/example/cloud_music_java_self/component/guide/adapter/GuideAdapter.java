package com.example.cloud_music_java_self.component.guide.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cloud_music_java_self.adapter.BaseFragmentStatePagerAdapter;
import com.example.cloud_music_java_self.component.guide.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 引导界面适配器
 */
public class GuideAdapter extends BaseFragmentStatePagerAdapter<Integer> {


    /**
     * 构造方法
     *
     * @param fm
     */
    public GuideAdapter(Context context, @NonNull FragmentManager fm) {
        super(context, fm);
    }

    /**
     * 下标为position的Fragment
     *
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
//        Integer data = datum.get(position);
//        return GuideFragment.newInstance(data);
        return GuideFragment.newInstance(getData(position));
    }
}