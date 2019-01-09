package com.test.myfirstmodule.constant;

/**
 * @Author： Victory
 * @Time： 2018/12/28
 * @QQ： 949021037
 * @Explain： com.test.myfirstmodule.constant
 */
public class BaseConstant {
    /**
     * 是否是调试状态
     */
    public final boolean isDebug = true;

    /**
     * 网络请求地址 正式
     */
    public final String baseUrl = "http://www.wanandroid.com/";

    /**
     * 网络请求地址 测试
     */
    public final String baseUrlDebug = "http://www.wanandroid.com/";

    /**
     * 每页请求行数
     */
    public final int itemNumber = 10;

    /**
     * 日志TAG前缀
     */

    public final String TAGD = "Victory-D";

    public final String TAGI = "Victory-I";

    public final String TAGE = "Victory-E";

    /**
     * 网络请求日志TAG
     */

    public final String TAGNETD = "Victory-NETD";

    public final String TAGNETI = "Victory-NETI";

    public final String TAGNETE = "Victory-NETE";

    /**
     * 网络请求超时时间
     */
    public final int outTime=10;
}
