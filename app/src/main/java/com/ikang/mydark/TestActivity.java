package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ikang.mydark.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);


        ObjectTool<String> oStr = new ObjectTool<>();
        String s  = oStr.getObj();

    }
}