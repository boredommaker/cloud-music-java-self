package com.example.cloud_music_java_self.component.me.fragment;

import android.os.Bundle;

import com.example.cloud_music_java_self.databinding.FragmentMeBinding;
import com.example.cloud_music_java_self.fragment.BaseViewModelFragment;

/**
 * 首页-我界面
 */
public class MeFragment extends BaseViewModelFragment<FragmentMeBinding> {
    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}