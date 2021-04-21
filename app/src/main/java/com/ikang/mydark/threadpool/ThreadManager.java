package com.ikang.mydark.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2020/11/10 0010
 * 邮箱：chenggang.zhang@ikang.com
 */
public class ThreadManager {

    //创建基本线程池
    public static  ThreadPoolExecutor threadPoolExecutor;



    public static ThreadPoolExecutor getThreadPoolExecutor(){

        Executors.newFixedThreadPool(5);

        if(null == threadPoolExecutor)
            threadPoolExecutor = new ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50));
        return threadPoolExecutor;

    }



}
