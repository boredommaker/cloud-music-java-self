package com.example.cloud_music_java_self.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.cloud_music_java_self.activity.BaseCommonActivity;

/**
 * 所有DialogFragment对话框父类
 */
public abstract class BaseDialogFragment extends DialogFragment {
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
        //获取view，抽象方法，交给子类实现
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
     * View创建后，模板方法
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
     * 给子类的Fragment提供一个findViewById，这样就不用重复写getView()了
     * @param id
     * @return
     * @param <T>
     */
    public <T extends View> T findViewById(@IdRes int id) {// 只能传R.id.xxx
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