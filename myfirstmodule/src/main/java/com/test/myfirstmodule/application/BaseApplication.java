package com.test.myfirstmodule.application;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Author： Victory
 * @Time： 2018/12/26
 * @QQ： 949021037
 * @Explain： com.test.myfirstmodule.application
 */
public class BaseApplication extends Application {

    /**
     * 设置全局上下文
     */
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        /**
         * 阿里路由框架初始化
         */
        if (true) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public static Context getContext() {
        return mContext;
    }


}
