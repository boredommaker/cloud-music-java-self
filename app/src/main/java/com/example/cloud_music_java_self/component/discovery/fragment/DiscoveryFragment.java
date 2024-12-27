package com.example.cloud_music_java_self.component.discovery.fragment;

import android.os.Bundle;

import com.example.cloud_music_java_self.databinding.FragmentDiscoveryBinding;
import com.example.cloud_music_java_self.fragment.BaseViewModelFragment;

public class DiscoveryFragment extends BaseViewModelFragment<FragmentDiscoveryBinding> {
    public static DiscoveryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
