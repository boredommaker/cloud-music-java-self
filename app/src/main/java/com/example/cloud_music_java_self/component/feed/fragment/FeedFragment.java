package com.example.cloud_music_java_self.component.feed.fragment;

import android.os.Bundle;

import com.example.cloud_music_java_self.databinding.FragmentFeedBinding;
import com.example.cloud_music_java_self.fragment.BaseViewModelFragment;

/**
 * 首页-动态界面
 */
public class FeedFragment extends BaseViewModelFragment<FragmentFeedBinding> {
    public static FeedFragment newInstance() {

        Bundle args = new Bundle();

        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
