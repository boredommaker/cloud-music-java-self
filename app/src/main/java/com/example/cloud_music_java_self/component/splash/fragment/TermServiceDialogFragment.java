package com.example.cloud_music_java_self.component.splash.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.cloud_music_java_self.R;
import com.example.cloud_music_java_self.databinding.FragmentDialogTermServiceBinding;
import com.example.cloud_music_java_self.fragment.BaseDialogFragment;
import com.example.cloud_music_java_self.fragment.BaseViewModelDialogFragment;
import com.example.cloud_music_java_self.util.ScreenUtil;
import com.example.cloud_music_java_self.util.SuperTextUtil;
import com.example.superui.process.SuperProcessUtil;
import com.google.android.material.button.MaterialButton;

/**
 * 服务条款和隐私协议对话框
 */
public class TermServiceDialogFragment extends BaseViewModelDialogFragment<FragmentDialogTermServiceBinding> {

    private static final String TAG = "TermServiceDialogFragment";

    private TextView contentView;
    private MaterialButton primaryView;
    private Button disagreeView;

    private View.OnClickListener onAgreementClickListener;
    @Override
    protected void initViews() {
        super.initViews();

        // 点击弹窗外后，无法关闭
        setCancelable(false);


        contentView = findViewById(R.id.content);
        primaryView = findViewById(R.id.primary);
        disagreeView = findViewById(R.id.disagree);

        // 设置颜色，以及可点击
        SuperTextUtil.setLinkColor(contentView, getActivity().getColor(R.color.link));
    }

    @Override
    protected void initDatum() {
        super.initDatum();

        Spanned content = Html.fromHtml(getString(R.string.term_service_privacy_content));

        //常规写法
//        SpannableStringBuilder result = SuperTextUtil.setHtmlLinkClick(content, new SuperTextUtil.OnLinkClickListener() {
//            @Override
//            public void onLinkClick(String data) {
//                Log.d(TAG, "onLinkClick: "+data);
//            }
//        });


        // 转换成带链接可点击的文本
        //lambda写法，监听器里面只有一个方法才能这样写
        SpannableStringBuilder result = SuperTextUtil.setHtmlLinkClick(
                content,
                data -> Log.d(TAG, "onLinkClick: " + data)
        );
        contentView.setText(result);
    }


    @Override
    protected void initListeners() {
        super.initListeners();

        primaryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// 同意后应该让SplashActivity处理，比如进入到主页面
                dismiss();// 关掉fragment
                onAgreementClickListener.onClick(view);
            }
        });
        disagreeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                SuperProcessUtil.killApp();
            }
        });
    }

    // 打 newInstance() 自动生成，写法比较固定
    public static TermServiceDialogFragment newInstance() {

        Bundle args = new Bundle();
        
        TermServiceDialogFragment fragment = new TermServiceDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }
    /**
     * 显示对话框
     *
     * @param fragmentManager
     * @param onAgreementClickListener 同意按钮的点击回调
     */
    public static void show(FragmentManager fragmentManager, View.OnClickListener onAgreementClickListener) {
        TermServiceDialogFragment fragment = newInstance();
        fragment.onAgreementClickListener = onAgreementClickListener;

        // 打开这个fragment
        fragment.show(fragmentManager, TAG);
    }

//    @Override
//    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_dialog_term_service, container, false);
//    }


    // 又是写法比较固定
    @Override
    public void onResume() {
        super.onResume();
        //修改宽度，默认比AlertDialog.Builder显示对话框宽度窄，看着不好看
        //参考：https://stackoverflow.com/questions/12478520/how-to-set-dialogfragments-width-and-height
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();

        params.width = (int) (ScreenUtil.getScreenWith(getContext()) * 0.9);// 宽度的0.9倍
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

}