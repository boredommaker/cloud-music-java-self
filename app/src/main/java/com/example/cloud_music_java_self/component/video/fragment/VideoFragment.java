package com.example.cloud_music_java_self.component.video.fragment;

import android.os.Bundle;

import com.example.cloud_music_java_self.databinding.FragmentVideoBinding;
import com.example.cloud_music_java_self.fragment.BaseViewModelFragment;

/**
 * 首页-视频界面
 */
public class VideoFragment extends BaseViewModelFragment<FragmentVideoBinding> {
    public static VideoFragment newInstance() {

        Bundle args = new Bundle();

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
