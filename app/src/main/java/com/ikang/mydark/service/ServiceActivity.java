package com.ikang.mydark.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ikang.mydark.R;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tvCount, tvStart, tvStartService;

    private Timer timer;
    private TimerTask timerTask;
    private int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        tvCount = findViewById(R.id.tvCount);
        tvStart = findViewById(R.id.tvStart);
        tvStartService = findViewById(R.id.tvStartService);


        tvCount.setOnClickListener(this);
        tvStart.setOnClickListener(this);
        tvStartService.setOnClickListener(this);

        Log.e("2222   MyService--->>>", "count::"+ count + "----Thread::" + Thread.currentThread().getName());
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                Log.e("0000   MyService--->>>", "count::"+ count + "----Thread::" + Thread.currentThread().getName());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvCount.setText("现在是第" + count + "次");
                    }
                });
            }
        };





    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvCount:
                count = 0;
                timer.cancel();
                break;

            case R.id.tvStart:
                timer.schedule(timerTask, 0, 300);
                break;

            case R.id.tvStartService:
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
        }

    }
}