package com.example.cloud_music_java_self.activity;


import android.content.Intent;

import com.example.cloud_music_java_self.component.guide.activity.GuideActivity;

/**
 * 通用界面逻辑
 */
public class BaseCommonActivity extends BaseActivity {

    // 启动界面
    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 启动另一个页面并关掉当前页面
     * @param clazz
     */
    protected void startActivityAfterFinishThis(Class<?> clazz) {
//        Intent intent = new Intent(this, clazz);
//        startActivity(intent);
        startActivity(clazz);
        finish();
    }
}
