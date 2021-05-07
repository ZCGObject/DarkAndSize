package com.ikang.mydark.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 项目名称：MyDark
 * 描述：
 * 创建人：ZCG
 * 创建时间：2021/4/29 0029
 * 邮箱：chenggang.zhang@ikang.com
 */
public class MyService extends Service {






    private MyRunnable myRunnable;
    private int count;



    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            try {
                Log.e("3333   MyService--->>>", "threadName::"+ Thread.currentThread().getName() + "----count:" + count);
                Thread.sleep(2000);
                if(count == 10){
                    Log.e("444   MyService--->>>", "cransh::"+ (10/0));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(myRunnable);
        }
    };





    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().getId();
        Log.e("1111   MyService--->>>", "threadName::"+ threadName + "---threadId::" + threadId);
        myRunnable = new MyRunnable();
        handler.post(myRunnable);


    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "服务已经启动", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "服务已经停止", Toast.LENGTH_LONG).show();
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            count++;
            Message message = Message.obtain();
            message.what = 1;
            handler.sendMessage(message);
        }
    }
}
