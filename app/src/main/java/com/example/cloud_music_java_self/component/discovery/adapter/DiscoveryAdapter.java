package com.example.cloud_music_java_self.component.discovery.adapter;

import static com.example.cloud_music_java_self.util.Constant.STYLE_BANNER;

import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.component.ad.model.Ad;
import com.example.cloud_music_java_self.component.discovery.model.ui.BannerData;
import com.example.cloud_music_java_self.model.ui.BaseMultiItemEntity;
import com.example.cloud_music_java_self.util.Constant;
import com.example.cloud_music_java_self.util.ImageUtil;
import com.example.superui.util.DensityUtil;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;

/**
 * 发现界面适配器
 */
/**
 * 发现界面适配器
 */
public class DiscoveryAdapter extends BaseMultiItemQuickAdapter<BaseMultiItemEntity, BaseViewHolder> {

    private final Fragment fragment;

    public DiscoveryAdapter(Fragment fragment) {
        super(new ArrayList<>());
        this.fragment = fragment;

        //添加多类型布局

        //banner类型
        addItemType(Constant.STYLE_BANNER, R.layout.item_discovery_banner);
    }

    /**
     * 绑定数据方法
     * 复用等步骤不用管
     * 框架内部自动处理
     *
     * @param holder
     * @param d
     */
    @Override
    protected void convert(@NonNull BaseViewHolder holder, BaseMultiItemEntity d) {
        switch (holder.getItemViewType()) {
            case Constant.STYLE_BANNER:
                //banner
                BannerData data = (BannerData) d;

                Banner bannerView = holder.getView(R.id.banner);

                BannerImageAdapter<Ad> bannerImageAdapter = new BannerImageAdapter<Ad>(data.getData()) {

                    @Override
                    public void onBindView(BannerImageHolder holder, Ad data, int position, int size) {
                        ImageUtil.show(getContext(), (ImageView) holder.itemView, data.getIcon());
                    }
                };

                bannerView.setAdapter(bannerImageAdapter);

                bannerView.setBannerRound(DensityUtil.dip2px(getContext(), 10));

                //添加生命周期观察者
                bannerView.addBannerLifecycleObserver(fragment);

                bannerView.setIndicator(new CircleIndicator(getContext()));
                break;
        }
    }
}
