package com.example.cloud_music_java_self.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.superui.reflect.ReflectUtil;

public abstract class BaseViewModelFragment<VB extends ViewBinding> extends BaseLogicFragment {
    protected VB binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ReflectUtil.newViewBinding(getLayoutInflater(), this.getClass());
    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}