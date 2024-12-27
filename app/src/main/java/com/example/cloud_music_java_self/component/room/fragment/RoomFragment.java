package com.example.cloud_music_java_self.component.room.fragment;

import android.os.Bundle;

import com.example.cloud_music_java_self.databinding.FragmentRoomBinding;
import com.example.cloud_music_java_self.fragment.BaseViewModelFragment;

/**
 * 首页-直播界面
 */
public class RoomFragment extends BaseViewModelFragment<FragmentRoomBinding> {
    public static RoomFragment newInstance() {

        Bundle args = new Bundle();

        RoomFragment fragment = new RoomFragment();
        fragment.setArguments(args);
        return fragment;
    }
}