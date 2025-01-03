package com.example.cloud_music_java_self.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cloud_music_java_self.activity.BaseCommonActivity;

/**
 * 所有Fragment通用父类
 */
public abstract class BaseFragment extends Fragment {
    /**
     * 找控件
     */
    protected void initViews() {

    }

    /**
     * 设置数据
     */
    protected void initDatum() {

    }

    /**
     * 绑定监听器
     */
    protected void initListeners() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取view
        View view = getLayoutView(inflater, container, savedInstanceState);

        //返回view
        return view;
    }

    /**
     * 获取view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * View创建了
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initDatum();
        initListeners();
    }


    /**
     * 给fragment增加findViewById
     */
    public <T extends View> T findViewById(@IdRes int id) {
        return getView().findViewById(id);
    }

    /**
     * 获取界面方法
     *
     * @return
     */
    protected BaseCommonActivity getHostActivity() {
        return (BaseCommonActivity) getActivity();
    }
}