package com.comingsoonsystem.network.httphelper;
import com.test.baseutils.LogUtil;
import com.test.myfirstmodule.constant.BaseConstant;

import okhttp3.*;

/**
 * @Author： Victory
 * @Time： 2018/12/10
 * @QQ： 949021037
 * @Explain： com.test.networkrequestmodule.httphelper
 */
public class NetWorkRequertLogInterceptor implements Interceptor {
    LogUtil logUtil = new LogUtil();
    BaseConstant constant = new BaseConstant();

    @Override
    public Response intercept(Chain chain) {
        /**
         * request 请求体
         * response 返回体
         * mediaType 媒介类型
         * content 返回body
         * stringparam 请求参数
         */
        Request request = null;
        Response response = null;
        MediaType mediaType = null;
        String content = "";
        StringBuffer stringparam;
        try {
            request = chain.request();
            response = chain.proceed(chain.request());

            /**
             * 添加头部信息
             *  request.header()
             *   request.headers();
             */
            stringparam = new StringBuffer();
            content = response.body().string();
            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    stringparam.append(body.encodedName(i) + ":" + body.encodedValue(i) + ",");
                }
                logUtil.printLogD(constant.TAGNETD, "-----" + "\nurl:" + request.url() + "\nparam:" + stringparam + "\nbody:" + content + "\n-----");
            } else {
                logUtil.printLogD(constant.TAGNETD, "-----" + "\nurl:" + request.url() + "\nparam:" + "JSON参数请在传递时打印" + "\nbody:" + content + "\n-----");
            }
        } catch (Exception e) {
            logUtil.printLogD(constant.TAGNETE, e.toString());
        }
        /**
         * okhttp调用一次后会close，所以新建了一个
         */
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
