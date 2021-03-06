package com.comingsoonsystem.network.model;

import com.comingsoonsystem.network.bean.BaseBean;
import com.comingsoonsystem.network.httphelper.NetWorkRequestHelper;
import com.comingsoonsystem.network.httphelper.NetWorkRequestServer;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

import java.util.Map;


/**
 * @Author： Victory
 * @Time： 2018/12/10
 * @QQ： 949021037
 * @Explain： com.test.networkrequestmodule.model
 */
public class BaseModel<T> {

    NetWorkRequestServer netRequestService;

    public BaseModel(Class<T> tClass) {
        netRequestService = (NetWorkRequestServer) NetWorkRequestHelper.getNetWorkRequestHelperInstance().getNetWorkRequestServer(tClass);
    }

    /**
     * post表单请求,返回object对象
     *
     * @param url
     * @param parme
     * @return
     */
    public Observable<Object> postFormRegisterObject(String url, Map<String, Object> parme) {
        return netRequestService.postRequestFormObject(url, parme);
    }

    /**
     * post表单请求,返回实体对象
     *
     * @param url
     * @param parme
     * @return
     */
    public Observable<BaseBean<T>> postFormRegisterBean(String url, Map<String, Object> parme) {
        return netRequestService.postRequestFormBean(url, parme);
    }

    /**
     *postJSON请求，返回Objet
     * @param url
     * @param parme
     * @return
     */
    public Observable<Object> postRequestJsonObject(String url, Map<String, Object> parme) {
        Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), gson.toJson(parme));
        return netRequestService.postRequestJsonObject(url, requestBody);
    }

}
