package com.example.cloud_music_java_self.component.guide.fragment;

import android.os.Bundle;

import com.example.cloud_music_java_self.databinding.FragmentGuideBinding;
import com.example.cloud_music_java_self.fragment.BaseViewModelFragment;

public class GuideFragment extends BaseViewModelFragment<FragmentGuideBinding> {

    @Override
    protected void initDatum() {
        super.initDatum();
        int data = getArguments().getInt("ID");
        binding.icon.setImageResource(data);
    }

    public static GuideFragment newInstance(Integer data) {

        Bundle args = new Bundle();
        args.putInt("ID", data);

        GuideFragment fragment = new GuideFragment();
        fragment.setArguments(args);
        return fragment;
    }





}