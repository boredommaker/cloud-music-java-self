package com.example.cloud_music_java_self.component.guide.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.cloud_music_java_self.component.guide.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 引导界面适配器
 */
public class GuideAdapter extends FragmentStatePagerAdapter {
    private List<Integer> datum = new ArrayList<>();

    /**
     * 构造方法
     *
     * @param fm
     */
    public GuideAdapter(@NonNull FragmentManager fm) {
        super(fm);
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
        Integer data = datum.get(position);
        return GuideFragment.newInstance(data);
    }

    /**
     * 有多少个
     *
     * @return
     */
    @Override
    public int getCount() {
        return datum.size();
    }

    public void setDatum(List<Integer> datum) {
        if (datum != null && datum.size() > 0) {
            this.datum.clear();
            this.datum.addAll(datum);

            // 告诉ViewPager数据变了
            notifyDataSetChanged();
        }
    }
}