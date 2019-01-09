package com.comingsoonsystem.network.httphelper;


import com.comingsoonsystem.network.bean.BaseBean;
import okhttp3.RequestBody;
import retrofit2.http.*;
import rx.Observable;

import java.util.Map;

/**
 * @Author： Victory
 * @Time： 2018/12/10
 * @QQ： 949021037
 * @Explain： com.test.networkrequestmodule.httphelper
 */
public interface NetWorkRequestServer<T> {

    /**
     * post请求表单提交，返回object类型
     *
     * @param url   请求地址
     * @param param 请求参数
     * @return
     */
    @FormUrlEncoded
    @POST
    Observable<Object> postRequestFormObject(@Url String url, @FieldMap Map<String, Object> param);

    /**
     * post请求表单提交，返回实体对象
     *
     * @param url   请求地址
     * @param param 请求参数
     * @return
     */
    @FormUrlEncoded
    @POST
    Observable<BaseBean<T>> postRequestFormBean(@Url String url, @FieldMap Map<String, Object> param);

    /**
     * post请求json提交，返回object类型
     *
     * @param url
     * @param data
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST
    Observable<Object> postRequestJsonObject(@Url String url, @Body RequestBody data);

    /**
     * post请求json提交，返回实体对象
     *
     * @param url
     * @param data
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST
    Observable<Object> postRequestJsonBean(@Url String url, @Body RequestBody data);

}
