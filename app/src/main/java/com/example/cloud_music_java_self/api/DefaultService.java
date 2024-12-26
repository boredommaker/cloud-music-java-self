package com.example.cloud_music_java_self.api;

import com.example.cloud_music_java_self.component.sheet.model.SheetWrapper;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 默认远程数据源
 */
public interface DefaultService {
    /**
     * 歌单列表
     *
     * @return
     */
    @GET("v1/sheets")
    Observable<SheetWrapper> sheets(@Query(value = "category") String category, @Query(value = "size") int size);
}
