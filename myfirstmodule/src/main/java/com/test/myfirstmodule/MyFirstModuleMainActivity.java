package com.test.myfirstmodule;


import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.test.myfirstmodule.activity.BaseActivity;
import com.test.myfirstmodule.rxbus.RxBus;


@Route(path = "/baseModule/firstActivity")
public class MyFirstModuleMainActivity extends BaseActivity {

    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfirst);
        test = findViewById(R.id.test);
        RxBus rxBu = RxBus.getRxBus();
        test.setText(rxBu.receive());
    }

}
