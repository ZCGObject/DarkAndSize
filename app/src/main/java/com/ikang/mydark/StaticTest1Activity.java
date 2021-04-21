package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ikang.mydark.util.FanXingUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StaticTest1Activity extends AppCompatActivity  implements View.OnClickListener{
    private Button btn, btnJump, btnJump1, btnJump2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_test1);

        btn = findViewById(R.id.btn);
        btnJump = findViewById(R.id.btnJump);
        btnJump1 = findViewById(R.id.btnJump1);
        btnJump2 = findViewById(R.id.btnJump2);
        tv = findViewById(R.id.tv);



        btn.setOnClickListener(this);
        btnJump.setOnClickListener(this);
        btnJump1.setOnClickListener(this);
        btnJump2.setOnClickListener(this);
        tv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnJump:
                startActivity(new Intent(this, StaticTestActivity.class));
                break;
            case R.id.btnJump1:
                setResult(2000);
                break;
            case R.id.btnJump2:
                setResult(3000);
                finish();
                break;
            case R.id.btn:
                SingleMode.I().num = 11;
                SingleMode.I().name = "我是第二次设置";
                break;
            case R.id.tv:
                tv.setText("name:::" + SingleMode.I().name + "num:::" + SingleMode.I().num);

                FanXingUtil fanXingUtil = new FanXingUtil();
                Object object = fanXingUtil.getObject(5);



                parseArray(5, String.class);
                parseArray1(5, "fff");
                parseArray1(5, String.class);


                break;
        }
    }


    public static <T> List<T> parseArray(int i, Class<T> object){
        T t = (T) String.valueOf(i);
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

    public static <T> List<T> parseArray1(int i, T object){

        T t = (T) String.valueOf(i);
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }



    private static Type getTType(Class<?> clazz) {
        Type mySuperClassType = clazz.getGenericSuperclass();
        Type[] types = ((ParameterizedType) mySuperClassType).getActualTypeArguments();
        if (types != null && types.length > 0) {
            //T
            return types[0];
        }
        return null;
    }



}