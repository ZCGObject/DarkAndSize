package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestReturnActivity extends AppCompatActivity {


    private Button btn;
    private String TAG = "TestReturn--->>>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_return_actvity);


        btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testReturn(5);
            }
        });
    }


    private void testReturn(int i){
        switch (i){
            case 5:

                if(i > 6){
                    Log.e(TAG,  "switch内部的代码 i > 0" );
                    return;
                }
                Log.e(TAG,  "switch内部的代码 i <= 0" );

                break;


            default:
                Log.e(TAG,  "switch内部的代码 default部分的代码" );
                break;
        }

        Log.e(TAG,  "switch之后执行的代码");
    }
}