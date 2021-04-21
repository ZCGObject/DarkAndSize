package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class TextBoldActivity extends AppCompatActivity {




    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_bold);


        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        tv9 = findViewById(R.id.tv9);
        tv10 = findViewById(R.id.tv10);
        tv15 = findViewById(R.id.tv15);



        tv1.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv2.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv3.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv4.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv5.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv6.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv7.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv8.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv9.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv10.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        tv15.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);


        tv1.getPaint().setStrokeWidth(1.1f);
        tv2.getPaint().setStrokeWidth(1.2f);
        tv3.getPaint().setStrokeWidth(1.3f);
        tv4.getPaint().setStrokeWidth(1.4f);
        tv5.getPaint().setStrokeWidth(1.5f);
        tv6.getPaint().setStrokeWidth(1.6f);
        tv7.getPaint().setStrokeWidth(1.7f);
        tv8.getPaint().setStrokeWidth(1.8f);
        tv9.getPaint().setStrokeWidth(1.9f);
        tv10.getPaint().setStrokeWidth(2.0f);
        tv15.getPaint().setStrokeWidth(3.0f);




    }
}