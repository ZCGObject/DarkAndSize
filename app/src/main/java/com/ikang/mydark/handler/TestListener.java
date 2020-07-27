package com.ikang.mydark.handler;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/7/22 0022
 * 邮箱：chenggang.zhang@ikang.com
 */
public class TestListener {





    private L ll;

    public TestListener() {
    }

    public void setListener(L l) {

        ll = l;
    }


    interface  L {
        void tt();
    }
}
