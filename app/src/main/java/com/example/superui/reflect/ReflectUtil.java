package com.example.superui.reflect;


import android.view.LayoutInflater;

import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * 反射工具类
 */
public class ReflectUtil {
    /**
     * 创建view binding
     * 通过反射从SplashActivity获取ActivitySplashBinding，需要用到ActivitySplashBinding的inflate
     */
    public static <VB extends ViewBinding> VB newViewBinding(LayoutInflater layoutInflater, Class<?> clazz) {
        try {
            //获取泛型参数对象
            ParameterizedType type;
            try {
                type = (ParameterizedType) clazz.getGenericSuperclass();
            } catch (ClassCastException e) {
                type = (ParameterizedType) clazz.getSuperclass().getGenericSuperclass();
            }

            // type: BaseViewModelActivity<ActivitySplashBinding>
            // type.actualTypeArguments[0]：ViewBinding
            Class<VB> clazzVB = (Class<VB>) type.getActualTypeArguments()[0];

            // clazzVB: ActivitySplashBinding
            //获取inflate方法
            Method inflateMethod = clazzVB.getMethod("inflate", LayoutInflater.class);

            //ActivitySplashBinding.inflate

            return (VB) inflateMethod.invoke(null, layoutInflater);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}