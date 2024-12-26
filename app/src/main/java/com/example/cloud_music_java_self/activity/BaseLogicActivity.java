package com.example.cloud_music_java_self.activity;

import com.example.cloud_music_java_self.util.PreferenceUtil;

/**
 * 项目中特有逻辑
 * <p>
 * 例如：显示迷你控制栏播放状态
 */
public class BaseLogicActivity extends BaseCommonActivity {

    protected PreferenceUtil sp;

    @Override
    protected void initDatum() {
        super.initDatum();
        sp = PreferenceUtil.getInstance(getHostActivity());
    }



    /**
     * 获取界面方法
     *
     * @return
     */
    protected BaseLogicActivity getHostActivity() {
        return this;
    }
}
