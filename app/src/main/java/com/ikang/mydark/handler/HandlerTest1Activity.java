package com.ikang.mydark.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.ikang.mydark.R;

public class HandlerTest1Activity extends AppCompatActivity {

//    private TextView tv1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };

    TestListener testListener;

    TestListener.L lll = new TestListener.L() {
        @Override
        public void tt() {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test1);

//        tv1 = findViewById(R.id.tv1);


        testListener = new TestListener();

        testListener.setListener(lll);



        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                tv1.setText("handler执行完成");
//                Toast.makeText(HandlerTest1Activity.this, "handler执行完成", Toast.LENGTH_SHORT).show();
//                System.gc();
//                System.runFinalization();

            }
        }, 30000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
    }
}