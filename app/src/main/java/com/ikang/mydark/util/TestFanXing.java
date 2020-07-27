package com.ikang.mydark.util;

import android.app.Activity;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/7/24 0024
 * 邮箱：chenggang.zhang@ikang.com
 */
public class TestFanXing {

    public <T> void getData(final Activity activity, final RequestListener<T> l){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Type type = getTType(l.getClass());
                            String s = "{\"name\":\"success\"}";
                            l.onSuccess((T) JSONObject.parseObject(s, type));
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private Type getTType(Class<?> clazz) {
        Type mySuperClassType = clazz.getGenericSuperclass();
        Type[] types = ((ParameterizedType) mySuperClassType).getActualTypeArguments();
        if (types != null && types.length > 0) {
            //T
            return types[0];
        }
        return null;
    }

}
