package com.example.cloud_music_java_self.component.discovery.model.ui;

import com.example.cloud_music_java_self.component.ad.model.Ad;
import com.example.cloud_music_java_self.model.ui.BaseMultiItemEntity;
import com.example.cloud_music_java_self.util.Constant;

import java.util.List;

/**
 * 发现界面，轮播图数据
 */
public class BannerData implements BaseMultiItemEntity {
    private List<Ad> data;

    public BannerData(List<Ad> data) {
        this.data = data;
    }

    public List<Ad> getData() {
        return data;
    }

    public void setData(List<Ad> data) {
        this.data = data;
    }

    @Override
    public int getItemType() {
        return Constant.STYLE_BANNER;
    }
}