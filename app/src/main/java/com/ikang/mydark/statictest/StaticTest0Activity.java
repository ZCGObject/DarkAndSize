package com.ikang.mydark.statictest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ikang.mydark.R;
import com.ikang.mydark.threadpool.AppExecutors;

import java.util.concurrent.Callable;

public class StaticTest0Activity extends AppCompatActivity  implements View.OnClickListener {

    private TextView tv, tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_test2);

        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);

        tv.setOnClickListener(this);
        tv1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                StaticTest.getInstance().count = 666;
                StaticTest.getInstance().student.name = "11111";
                Log.e("000  count---->>>" ,  StaticTest.getInstance().count+"---" + StaticTest.getInstance().student.name);
                break;
            case R.id.tv1:
                startActivity(new Intent(this, StaticTest2Activity.class));
                break;
        }
    }
}