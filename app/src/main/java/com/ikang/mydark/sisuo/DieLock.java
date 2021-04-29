package com.ikang.mydark.sisuo;

import android.util.Log;

public class DieLock {
    public static String TAG = "DieLock-->>>";
    public static Object t1 = new Object();
    public static Object t2 = new Object();

    public static void siSuo() {
        new Thread() {
            @Override
            public void run() {
                synchronized (t1) {
                    Log.e(TAG, "Thread1 get t1");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Log.e(TAG, "Thread1 doing 111");
                    synchronized (t2) {
                        Log.e(TAG, "Thread1 get t2");
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (t2) {
                    Log.e(TAG, "Thread2 get t2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    Log.e(TAG, "Thread2 doing 222");
                    synchronized (t1) {
                        Log.e(TAG, "Thread2 get t1");
                    }
                }
            }
        }.start();
    }

}