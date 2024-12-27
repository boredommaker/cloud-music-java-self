package com.example.cloud_music_java_self.component.discovery.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.model.ui.BaseMultiItemEntity;
import com.example.cloud_music_java_self.util.Constant;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;

/**
 * 发现界面适配器
 */
public class DiscoveryAdapter extends BaseMultiItemQuickAdapter<BaseMultiItemEntity, BaseViewHolder> {

    public DiscoveryAdapter() {
        super(new ArrayList<>());

        //添加多类型布局

        //banner类型
        addItemType(Constant.STYLE_BANNER, R.layout.item_discovery_banner);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, BaseMultiItemEntity d) {

    }
}
