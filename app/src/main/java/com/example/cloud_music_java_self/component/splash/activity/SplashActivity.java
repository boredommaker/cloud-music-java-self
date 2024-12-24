package com.example.cloud_music_java_self.component.splash.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.util.SuperDateUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);

        //状态栏文字黑色
        QMUIStatusBarHelper.setStatusBarLightMode(this);

        //设置版本年份
        int year = SuperDateUtil.currentYear();

        TextView copyrightView = findViewById(R.id.copyright);
        copyrightView.setText(getResources().getString(R.string.copyright, year));
    }
}