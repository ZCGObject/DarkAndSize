package com.ikang.mydark.statictest;

import com.ikang.mydark.threadpool.AppExecutors;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/11/10 0010
 * 邮箱：chenggang.zhang@ikang.com
 */
public class StaticTest {


    public int count;

    public Student student;

    private static StaticTest instance;

    private static Object object = new Object();

    public static StaticTest getInstance() {
        if (instance == null) {
            synchronized (object) {
                if (instance == null) {
                    instance = new StaticTest();
                }
            }
        }
        return instance;
    }


    private StaticTest(){
        student = new Student();
    }

    public void reSetStaticTest(){
        instance = null;
    }

}
