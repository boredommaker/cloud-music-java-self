package com.example.cloud_music_java_self.component.guide.activity;


import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.cloud_music_java_self.MainActivity;
import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.activity.BaseViewModelActivity;
import com.example.cloud_music_java_self.api.DefaultService;
import com.example.cloud_music_java_self.api.NetworkModule;
import com.example.cloud_music_java_self.component.comment.model.Comment;
import com.example.cloud_music_java_self.component.guide.adapter.GuideAdapter;
import com.example.cloud_music_java_self.component.observer.ObserverAdapter;
import com.example.cloud_music_java_self.component.sheet.model.SheetWrapper;
import com.example.cloud_music_java_self.config.Config;
import com.example.cloud_music_java_self.databinding.ActivityGuideBinding;
import com.example.cloud_music_java_self.model.response.DetailResponse;
import com.example.cloud_music_java_self.model.response.ListResponse;
import com.example.cloud_music_java_self.util.Constant;
import com.example.cloud_music_java_self.util.SuperDarkUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.example.cloud_music_java_self.component.sheet.model.Sheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * 左右滚动的引导界面
 * 如果想实现更复杂的效果，例如：滚动时文本缩放等效果，可以使用类似这样的框架：
 * https://github.com/bingoogolapple/BGABanner-Android
 */
public class GuideActivity extends BaseViewModelActivity<ActivityGuideBinding> implements View.OnClickListener{


    private static final String TAG = "GuideActivity";
    private GuideAdapter adapter;
    private DefaultService service;

    @Override
    protected void initViews() {
        super.initViews();
        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);

        if (SuperDarkUtil.isDark(this)) {
            //状态栏文字白色
            QMUIStatusBarHelper.setStatusBarDarkMode(this);
        } else {
            //状态栏文字黑色
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }
    }

    @Override
    protected void initDatum() {
        super.initDatum();

        OkHttpClient okHttpClient = NetworkModule.provideOkHttpClient();
        Retrofit retrofit = NetworkModule.provideRetrofit(okHttpClient);
        service = retrofit.create(DefaultService.class);








        //创建适配器
        adapter = new GuideAdapter(getHostActivity(), getSupportFragmentManager());

        //适配器和控价绑定
        binding.list.setAdapter(adapter);

        // 指示器部分
        //让指示器根据列表控件配合工作
        binding.indicator.setViewPager(binding.list);

        //适配器注册数据源观察者
        adapter.registerDataSetObserver(binding.indicator.getDataSetObserver());



        //准备数据
        List<Integer> datum = new ArrayList<>();
        datum.add(R.drawable.guide1);
        datum.add(R.drawable.guide2);
        datum.add(R.drawable.guide3);
        datum.add(R.drawable.guide4);
        datum.add(R.drawable.guide5);


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

            Intent intent = new Intent(getHostActivity(), MainActivity.class);
            intent.setAction(Constant.ACTION_LOGIN);
            startActivity(intent);



            setShowGuide();
            finish();
        }
        else if (v.getId() == R.id.experience_now) {

//                startActivityAfterFinishThis(MainActivity.class);
//
//                setShowGuide();
//            testGet();


            testGetRetrofitGet();
        }

    }

    /**
     * retrofit get
     */
    private void testGetRetrofitGet() {
//        service.sheets(null, 2)
//                .subscribeOn(Schedulers.io())// 放在子线程执行
//                .observeOn(AndroidSchedulers.mainThread())// 以下代码在主线程执行
//                .subscribe(new Observer<ListResponse<Sheet>>() {
//                    @Override
//                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull ListResponse<Sheet> data) {
//                        Sheet sheet = data.getData().getData().get(0);
//                        Log.d(TAG, "onNext: " + sheet.getTitle());
//                    }
//
//                    @Override
//                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
//                        Log.d(TAG, "onError: " + e.getLocalizedMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//        service.comments()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ListResponse<Comment>>() {
//                    @Override
//                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull ListResponse<Comment> data) {
//                        Comment sheet = data.getData().getData().get(0);
//                        Log.d(TAG, "onNext: " + sheet.getContent());
//                    }
//
//                    @Override
//                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
//                        Log.d(TAG, "onError: " + e.getLocalizedMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//        service.sheetDetail("ixuea", "1")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<DetailResponse<Sheet>>() {
//                    @Override
//                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull DetailResponse<Sheet> data) {
//                        Log.d(TAG, "onNext: " + data.getData().getTitle());
//
//                    }
//
//                    @Override
//                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
//                        Log.e(TAG, "onError: " + e.getLocalizedMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
        service.sheetDetail("ixuea", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverAdapter<DetailResponse<Sheet>>() {
                    @Override
                    public void onNext(@NonNull DetailResponse<Sheet> sheetDetailResponse) {
                        super.onNext(sheetDetailResponse);
                    }
                });
    }

    /**
     * okhttp get请求
     */
    private void testGet() {
        Log.d(TAG, "testGet");
        OkHttpClient client = new OkHttpClient();

        String url = Config.ENDPOINT + "v1/sheets";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "get error: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d(TAG, "get success: " + response.body().string());
            }
        });
    }

    private void setShowGuide() {
        sp.setShowGuide(false);
    }
}
