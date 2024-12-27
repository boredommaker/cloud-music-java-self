package com.example.cloud_music_java_self.fragment;

/**
 * 项目中特有逻辑
 */
public abstract class BaseLogicFragment extends BaseCommonFragment {
    /**
     * 加载数据方法
     *
     * @param isPlaceholder 是否是通过placeholder控件触发的
     */
    protected void loadData(boolean isPlaceholder) {

    }

    /**
     * 加载数据方法
     */
    protected void loadData() {
        loadData(false);
    }
}
