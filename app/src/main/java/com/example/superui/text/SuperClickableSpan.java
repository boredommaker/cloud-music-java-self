package com.example.superui.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

import androidx.annotation.NonNull;

/**
 * 自定义ClickableSpan
 * 目的是去除下划线
 * 给某段文本添加点击事件
 */
public abstract class SuperClickableSpan extends ClickableSpan {
    /**
     * 更新绘制状态
     *  又是固定的??
     * @param ds
     */
    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        //只设置颜色
        ds.setColor(ds.linkColor);

        //去掉下划线
        ds.setUnderlineText(false);
    }


}