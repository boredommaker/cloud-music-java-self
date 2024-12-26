package com.example.cloud_music_java_self.component.guide.activity;


import android.view.View;

import com.example.cloud_music_java_self.MainActivity;
import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.activity.BaseViewModelActivity;
import com.example.cloud_music_java_self.databinding.ActivityGuideBinding;

/**
 * 左右滚动的引导界面
 * 如果想实现更复杂的效果，例如：滚动时文本缩放等效果，可以使用类似这样的框架：
 * https://github.com/bingoogolapple/BGABanner-Android
 */
public class GuideActivity extends BaseViewModelActivity<ActivityGuideBinding> implements View.OnClickListener{
    @Override
    protected void initListeners() {
        super.initListeners();
        binding.loginOrRegister.setOnClickListener(this);
        binding.experienceNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_or_register) {

            setShowGuide();

        }
        else if (v.getId() == R.id.experience_now) {

            startActivityAfterFinishThis(MainActivity.class);

            setShowGuide();
        }

    }

    private void setShowGuide() {
//        ()
    }
}
