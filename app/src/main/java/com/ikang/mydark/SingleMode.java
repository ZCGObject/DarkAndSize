package com.ikang.mydark;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/7/17 0017
 * 邮箱：chenggang.zhang@ikang.com
 */
public class SingleMode {
    private static SingleMode mSingleMode;
    public int num;
    public String name;


    public static synchronized SingleMode I(){
        if (mSingleMode == null){
            mSingleMode = new SingleMode();
        }
        return mSingleMode;
    }
}
