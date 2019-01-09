package com.test.testmodule;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.launcher.ARouter;
import com.comingsoonsystem.network.httphelper.NetWorkRequestServer;
import com.comingsoonsystem.network.model.BaseModel;
import com.comingsoonsystem.network.presenter.BasePresenter;
import com.comingsoonsystem.network.view.BaseView;
import com.test.baseutils.CommonUtil;
import com.test.baseutils.LogUtil;
import com.test.myfirstmodule.activity.BaseActivity;
import com.test.myfirstmodule.rxbus.RxBus;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;


/**
 * @Author： Victory
 * @Time： 2018/10/11
 * @QQ： 949021037
 * @Explain： com.test.testmodule
 */
public class MainActivity extends BaseActivity {

    TextView txt;
    LogUtil logUtil;
    CommonUtil commonUtil;
    BaseModel baseModel;
    BaseView baseView;
    BasePresenter basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        logUtil = new LogUtil();
        commonUtil=CommonUtil.getCommonUtil(this);
        txt = findViewById(R.id.txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,MyFirstModuleMainActivity.class));
//                ARouter.getInstance().build("/baseModule/firstActivity").navigation();

//                RxBus rxBus=RxBus.getRxBus();
//                rxBus.post("我是测试发送数据");

//                logUtil.printLogD("testT" + getClass().getName(), "我是测试Debug");
//                logUtil.printLogI("testT" + getClass().getName(), "我是测试Info");
//                logUtil.printLogE("testT" + getClass().getName(), "我是测试Error");



//                logUtil.printLogD("testT" + getClass().getName(), "50dp="+commonUtil.dp2px(50)+"px,AppVersion="+commonUtil.getAppVersion()+",OSVersion="+commonUtil.getOSVersion());


                testNetWork();
            }
        });

    }

    private void testNetWork(){
        baseView=new BaseView() {
            @Override
            public void requestSuccess(Object data) {
                logUtil.printLogD("testT" + getClass().getName(), data.toString());
            }

            @Override
            public void requestError(String errorMessage) {

            }
        };
        basePresenter=new BasePresenter();
        baseModel=new BaseModel(NetWorkRequestServer.class);
        basePresenter.onRequestStart(baseView);
        Map<String,String> map=new HashMap<>();
        map.put("username","victory");
        map.put("password","123456");
        basePresenter.getObjectData(baseModel.postFormRegisterObject("http://www.wanandroid.com/user/login",map));
    }
}
