package com.ikang.mydark;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import com.ikang.mydark.util.SharePreferenceUtils;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/5/23
 * 邮箱：chenggang.zhang@ikang.com
 */
public class BaseApplication extends Application {




    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("BaseApplication::", "myPid:" + android.os.Process.myPid());//设置正常字体大小的倍数

        SharePreferenceUtils.put(this,"fs",1.0f);

//        CrashHandler.getInstance().init(this);
    }

    @Override
    public Resources getResources() {

        Resources res = super.getResources();
        Configuration config = res.getConfiguration();
        config.fontScale = 2.0f;
        Log.e("Base---fontScale::", config.fontScale+"");//设置正常字体大小的倍数
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}
