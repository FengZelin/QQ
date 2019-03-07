package com.example.asus.qq;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * data:2019/3/7
 * author:冯泽林（asus）
 * function:
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5ba98783f1f5564fa90000b3 "
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
