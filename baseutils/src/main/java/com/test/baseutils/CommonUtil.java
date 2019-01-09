package com.test.baseutils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * @Author： Victory
 * @Time： 2019/1/7
 * @QQ： 949021037
 * @Explain： com.test.commonutils
 */
public class CommonUtil {

    private static CommonUtil commonUtil;
    private static Context mContext;

    public static CommonUtil getCommonUtil(Context context) {
        if (commonUtil == null) {
            commonUtil = new CommonUtil();
        }
        mContext = context;
        return commonUtil;
    }

    /**
     * dp转px
     *
     * @param dp
     * @return
     */
    public int dp2px(int dp) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * px转dp
     *
     * @param px
     * @return
     */
    public int px2dp(int px) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param sp
     * @return
     */
    public int sp2px(int sp) {
        float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param px
     * @return
     */
    public int px2sp(int px) {
        float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / fontScale + 0.5f);
    }

    /**
     * 获取app版本
     *
     * @return
     */
    public String getAppVersion() {
        try {
            return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "暂无版本信息";
        }
    }

    /**
     * 获取当前系统版本
     */
    public int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取当前手机厂商
     */
    public String getPhoneManufacturers() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public String getPhoneModel() {
        return Build.MODEL;
    }
}
