package com.ikang.mydark.xiecheng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ikang.mydark.R;
import com.ikang.mydark.databinding.ActivityXiechengTest1Binding;

public class XieChengTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xie_cheng_text);

        ActivityXiechengTest1Binding b = DataBindingUtil.setContentView(this, R.layout.activity_xiecheng_test1);



    }
}