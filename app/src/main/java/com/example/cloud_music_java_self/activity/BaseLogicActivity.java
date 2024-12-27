package com.example.cloud_music_java_self.activity;

import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.util.PreferenceUtil;
import com.example.superui.loading.SuperRoundLoadingDialogFragment;

import java.lang.ref.WeakReference;

/**
 * 项目中特有逻辑
 * <p>
 * 例如：显示迷你控制栏播放状态
 */
public class BaseLogicActivity extends BaseCommonActivity {

    protected PreferenceUtil sp;

    // 弱引用?
    private WeakReference<SuperRoundLoadingDialogFragment> loadingWeakReference;

    @Override
    protected void initDatum() {
        super.initDatum();
        sp = PreferenceUtil.getInstance(getHostActivity());
    }



    /**
     * 获取界面方法
     *
     * @return
     */
    protected BaseLogicActivity getHostActivity() {
        return this;
    }
    /**
     * 显示加载对话框
     */
    public void showLoading() {
        showLoading(getString(R.string.loading));
    }

    /**
     * 显示加载对话框
     */
    public void showLoading(int data) {
        showLoading(getString(data));
    }

    /**
     * 显示加载对话框
     */
    public void showLoading(String message) {
        if (loadingWeakReference == null || loadingWeakReference.get() == null) {
            loadingWeakReference = new WeakReference<>(
                    SuperRoundLoadingDialogFragment.newInstance(message)
            );
        }

        SuperRoundLoadingDialogFragment dialog = loadingWeakReference.get();
        if (dialog.getDialog() == null || !dialog.getDialog().isShowing()) {
            dialog.show(getSupportFragmentManager(), "SuperRoundLoadingDialogFragment");
        }
    }

    /**
     * 隐藏加载对话框
     */
    public void hideLoading() {
        SuperRoundLoadingDialogFragment dialog = loadingWeakReference.get();
        if (dialog != null) {
            dialog.dismiss();
            loadingWeakReference.clear();
        }
        loadingWeakReference = null;
    }
}
