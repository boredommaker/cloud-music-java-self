package com.example.cloud_music_java_self.util;

import com.example.cloud_music_java_self.config.Config;

/**
 * 资源工具类
 */
public class ResourceUtil {
    /**
     * 将相对资源转为绝对路径
     *
     * @param data 放到自己服务端的资源以files开头，其他资源都在阿里云oss
     * @return
     */
    public static String resourceUri(String data) {
        return String.format(Config.RESOURCE_ENDPOINT, data);
    }
}
