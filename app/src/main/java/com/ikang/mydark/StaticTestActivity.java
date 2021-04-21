package com.ikang.mydark;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ikang.mydark.util.BaseBean;
import com.ikang.mydark.util.BaseResult;
import com.ikang.mydark.util.Person;
import com.ikang.mydark.util.RequestListener;
import com.ikang.mydark.util.RequestNewListener;
import com.ikang.mydark.util.TestFanXing;

import java.util.List;

public class StaticTestActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn, btnJump, btnJump1, btn1;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_test);


        btn = findViewById(R.id.btn);
        btnJump = findViewById(R.id.btnJump);
        btnJump1 = findViewById(R.id.btnJump1);
        tv = findViewById(R.id.tv);
        btn1 = findViewById(R.id.btn1);


        btn.setOnClickListener(this);
        btnJump.setOnClickListener(this);
        btnJump1.setOnClickListener(this);
        tv.setOnClickListener(this);


        BaseBean<List<String>> f = new BaseBean<>();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TestFanXing().getData(StaticTestActivity.this, new RequestListener<Person>() {
                    @Override
                    public void onSuccess(Person person) {
                        Log.e("000  person--->>", person.toString());
                    }

                    @Override
                    public void onFailed(String err) {

                    }
                });


//                new TestFanXing().getData(StaticTestActivity.this, new RequestListener<String>() {
//                    @Override
//                    public void onSuccess(String s) {
//
//                    }
//
//                    @Override
//                    public void onFailed(String err) {
//
//                    }
//                });

//                new TestFanXing().getData(StaticTestActivity.this, new RequestListener<BaseResult>() {
//                    @Override
//                    public void onSuccess(BaseResult baseResult) {
//
//                    }
//
//                    @Override
//                    public void onFailed(String err) {
//
//                    }
//                });
//
//
//
//
//
//                new TestFanXing().getData(StaticTestActivity.this, new RequestListener<BaseBean<Person>>() {
//                    @Override
//                    public void onSuccess(BaseBean<Person> personBaseBean) {
//                        Person person = personBaseBean.result;
//                    }
//
//                    @Override
//                    public void onFailed(String err) {
//
//                    }
//                });
                new TestFanXing().getO(new RequestNewListener<Person>() {

                    @Override
                    public void onSuccess(Person person) {
                        Log.e("111  person--->>", person.toString());
                    }

                    @Override
                    public void onFailed(String err) {

                    }
                });

            }


        });


        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnJump:
                startActivity(new Intent(this, StaticTest1Activity.class));
                break;
            case R.id.btnJump1:
                startActivityForResult(new Intent(this, StaticTest1Activity.class), 1000);
                break;
            case R.id.btn:
                SingleMode.I().num = 10;
                SingleMode.I().name = "我是第一次设置";
                break;
            case R.id.tv:
                tv.setText("name:::" + SingleMode.I().name + "num:::" + SingleMode.I().num);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("onActivityResult--->>>", "onActivityResult::" + requestCode + resultCode);
    }


}