package com.test.baseutils;


import android.os.Bundle;

import com.test.myfirstmodule.activity.BaseActivity;

public class BaseUtilsMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
