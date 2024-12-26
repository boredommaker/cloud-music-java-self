package com.example.cloud_music_java_self.component.guide.activity;


import android.view.View;

import com.example.cloud_music_java_self.MainActivity;
import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.activity.BaseViewModelActivity;
import com.example.cloud_music_java_self.component.guide.adapter.GuideAdapter;
import com.example.cloud_music_java_self.databinding.ActivityGuideBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 左右滚动的引导界面
 * 如果想实现更复杂的效果，例如：滚动时文本缩放等效果，可以使用类似这样的框架：
 * https://github.com/bingoogolapple/BGABanner-Android
 */
public class GuideActivity extends BaseViewModelActivity<ActivityGuideBinding> implements View.OnClickListener{

    private GuideAdapter adapter;

    @Override
    protected void initDatum() {
        super.initDatum();
        //创建适配器
        adapter = new GuideAdapter(getSupportFragmentManager());

        //适配器和控价绑定
        binding.list.setAdapter(adapter);

        //准备数据
        List<Integer> datum = new ArrayList<>();
        datum.add(R.drawable.guide1);
        datum.add(R.drawable.guide2);
        datum.add(R.drawable.guide3);
        datum.add(R.drawable.guide4);
        datum.add(R.drawable.guide5);
        datum.add(R.drawable.splash_logo);
        datum.add(R.drawable.login_netease);
        //设置数据到适配器
        adapter.setDatum(datum);
    }


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
        sp.setShowGuide(false);
    }
}
