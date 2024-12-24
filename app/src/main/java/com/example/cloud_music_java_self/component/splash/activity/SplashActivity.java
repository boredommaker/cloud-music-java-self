package com.example.cloud_music_java_self.component.splash.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.activity.BaseLogicActivity;
import com.example.cloud_music_java_self.component.splash.fragment.TermServiceDialogFragment;
import com.example.cloud_music_java_self.util.DefaultPreferenceUtil;
import com.example.cloud_music_java_self.util.SuperDarkUtil;
import com.example.cloud_music_java_self.util.SuperDateUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class SplashActivity extends BaseLogicActivity {

    private static final String TAG = "SplashActivity";

    private TextView copyrightView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }


    @Override
    protected void initViews() {
        super.initViews();


        //设置沉浸式状态栏 -> 全屏
        QMUIStatusBarHelper.translucent(this);


        // 状态栏文本颜色
        if (SuperDarkUtil.isDark(this)) {
            // 黑色主题，状态栏文字白色
            QMUIStatusBarHelper.setStatusBarDarkMode(this);
        } else {
            // 白色主题，状态栏文字黑色
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }



        copyrightView = findViewById(R.id.copyright);
    }

    @Override
    protected void initDatum() {
        super.initDatum();

        //设置版本年份
        int year = SuperDateUtil.currentYear();
        copyrightView.setText(getResources().getString(R.string.copyright, year));

        // getHostActivity()使得activity和fragment写法一致
        if (DefaultPreferenceUtil.getInstance(getHostActivity()).isAcceptTermsServiceAgreement()) {
            prepareNext();

        } else {
            showTermsServiceAgreementDialog();
        }

    }

    private void showTermsServiceAgreementDialog() {
        TermServiceDialogFragment.show(getSupportFragmentManager(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {// 点击fragment中的同意后，应该执行什么
                DefaultPreferenceUtil.getInstance(getHostActivity()).setAcceptTermsServiceAgreement();

                prepareNext();
            }
        });
    }
    private void prepareNext() {
        Log.d(TAG, "同意用户协议后要执行的操作");
    }

}