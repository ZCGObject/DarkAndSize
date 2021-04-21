package com.ikang.mydark.statictest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ikang.mydark.R;

public class StaticTest2Activity extends AppCompatActivity  implements View.OnClickListener {


    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_test3);

        tv = findViewById(R.id.tv);

        tv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                StaticTest.getInstance().count++;
                Log.e("000  count---->>>" ,  StaticTest.getInstance().count+"---" + StaticTest.getInstance().student.name);
                StaticTest.getInstance().reSetStaticTest();
                Log.e("000  count---->>>" ,  StaticTest.getInstance().count+"---" + StaticTest.getInstance().student.name);


                break;
        }
    }
}