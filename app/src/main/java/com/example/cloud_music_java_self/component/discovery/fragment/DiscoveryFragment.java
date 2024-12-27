package com.example.cloud_music_java_self.component.discovery.fragment;

import static autodispose2.AutoDispose.autoDisposable;

import android.os.Bundle;

import com.example.cloud_music_java_self.api.HttpObserver;
import com.example.cloud_music_java_self.component.ad.model.Ad;
import com.example.cloud_music_java_self.component.discovery.model.ui.BannerData;
import com.example.cloud_music_java_self.databinding.FragmentDiscoveryBinding;
import com.example.cloud_music_java_self.fragment.BaseViewModelFragment;
import com.example.cloud_music_java_self.model.response.ListResponse;
import com.example.cloud_music_java_self.model.ui.BaseMultiItemEntity;
import com.example.cloud_music_java_self.repository.DefaultRepository;

import java.util.ArrayList;
import java.util.List;

import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.rxjava3.core.Observable;

public class DiscoveryFragment extends BaseViewModelFragment<FragmentDiscoveryBinding> {

    /**
     * 列表数据集合
     */
    private List<BaseMultiItemEntity> datum;

    @Override
    protected void initDatum() {
        super.initDatum();
        
        
        loadData();
    }

    @Override
    protected void loadData(boolean isPlaceholder) {
        super.loadData(isPlaceholder);

        datum = new ArrayList<>();

        //广告API
        Observable<ListResponse<Ad>> ads = DefaultRepository.getInstance().bannerAd();

        ads.
                to(autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new HttpObserver<ListResponse<Ad>>() {
                    @Override
                    public void onSucceeded(ListResponse<Ad> data) {
                        //添加轮播图
                        datum.add(new BannerData(
                                data.getData().getData()
                        ));
                    }
                });
    }

    public static DiscoveryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
