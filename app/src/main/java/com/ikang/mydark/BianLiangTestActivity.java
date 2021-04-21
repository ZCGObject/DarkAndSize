package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BianLiangTestActivity extends AppCompatActivity implements View.OnClickListener {


    public int testInt;

    public String testString;


    private TextView tvInt, tvString;

    private BianLiangBean bianLiangBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bian_liang_test);



        tvInt = findViewById(R.id.tvInt);
        tvString = findViewById(R.id.tvString);


        tvInt.setOnClickListener(this);
        tvString.setOnClickListener(this);

        testInt = 100;
        testString = "我是100";

        bianLiangBean = new BianLiangBean();

        bianLiangBean.setTestInt(testInt);
        bianLiangBean.setTestString(testString);



        ForMethod forMethod = new ForMethod();
        try {
            Method method = forMethod.getClass().getDeclaredMethod("getData", String.class);

            Type genericReturnType = method.getGenericReturnType();
            Type[] genericParameterTypes = method.getGenericParameterTypes();


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvInt:

                try {
                    Color.parseColor("#00bc63f9");
                }catch (Exception e){
                    Log.e("Exception--->>>" , e.toString());
                }


                testInt = 666;
//                bianLiangBean.setTestInt(testInt);
                Log.e("111--->>>" , bianLiangBean.toString());
                Log.e("222--->>>" , bianLiangBean.getTestInt()+"");
                break;
            case R.id.tvString:
                testString = "我是666";
//                bianLiangBean.setTestString(testString);
                Log.e("333--->>>" , bianLiangBean.toString());
                Log.e("444--->>>" , bianLiangBean.getTestString());
                break;
        }

    }


    public static void recursivelyCheckType(Type type){
        if(type instanceof ParameterizedType){
            for (Type ac : ((ParameterizedType)type).getActualTypeArguments()){
                recursivelyCheckType(ac);
            }
        }else {
            Log.e("---->>>", "ddddd");
        }
    }
}

