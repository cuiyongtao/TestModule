package com.test.baseutils;

import android.util.Log;

import com.test.myfirstmodule.constant.BaseConstant;

/**
 * @Author： Victory
 * @Time： 2019/1/9
 * @QQ： 949021037
 * @Explain： com.test.baseutils
 */
public class LogUtil {

    private static LogUtil logUtil;
    private BaseConstant baseConstant = new BaseConstant();

    /**
     * 获取logutils实例
     *
     * @return
     */
    public static LogUtil getLogUtil() {
        if (logUtil == null) {
            logUtil = new LogUtil();
        }
        return logUtil;
    }

    /**
     * info日志
     *
     * @param calssName
     * @param message
     */
    public void printLogI(String calssName, String message) {
        Log.i(baseConstant.TAGI + calssName, message);
    }

    /**
     * debug日志
     *
     * @param calssName
     * @param message
     */
    public void printLogD(String calssName, String message) {
        Log.d(baseConstant.TAGD + calssName, message);
    }

    /**
     * error日志
     *
     * @param calssName
     * @param message
     */
    public void printLogE(String calssName, String message) {
        Log.e(baseConstant.TAGE + calssName, message);
    }

}
