package com.example.cloud_music_java_self;

import android.content.Intent;

import com.example.cloud_music_java_self.activity.BaseViewModelActivity;
import com.example.cloud_music_java_self.component.login.activity.LoginHomeActivity;
import com.example.cloud_music_java_self.databinding.ActivityMainBinding;
import com.example.cloud_music_java_self.util.Constant;

public class MainActivity extends BaseViewModelActivity<ActivityMainBinding> {
    @Override
    protected void initDatum() {
        super.initDatum();

        String action = getIntent().getAction();

        if (Constant.ACTION_LOGIN.equals(action)) {
            startActivity(LoginHomeActivity.class);
        }

    }

}
