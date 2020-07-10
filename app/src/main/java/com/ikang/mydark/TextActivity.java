package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.binaryfork.spanny.Spanny;

public class TextActivity extends AppCompatActivity {


    TextView tv, tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text2);

        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);



        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spanny spanny = new Spanny("Underline text", new UnderlineSpan())
                        .append("\nBold text", new StyleSpan(Typeface.BOLD))
                        .append("\nPlain text");
                tv1.setText(new Spanny().append("FakeBold",new FakeBoldSpan()));
            }
        });

        tv.setText("我是中文");
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spanny spanny = new Spanny("Underline text", new UnderlineSpan())
                        .append("\nBold text", new StyleSpan(Typeface.BOLD))
                        .append("\nPlain text");
                tv2.setText(new Spanny().append("我是中文",new FakeBoldSpan1()));
            }
        });

        tv3.setText("我是中文");
    }


    //没错，就几行代码这么简单
    public class FakeBoldSpan extends CharacterStyle {

        @Override
        public void updateDrawState(TextPaint tp) {
            tp.setFakeBoldText(true);//一种伪粗体效果，比原字体加粗的效果弱一点
            // tp.setStyle(Paint.Style.FILL_AND_STROKE);
            // tp.setColor(Color.RED);//字体颜色
            // tp.setStrokeWidth(10);//控制字体加粗的程度
        }
    }
    //没错，就几行代码这么简单
    public class FakeBoldSpan1 extends CharacterStyle {
        @Override
        public void updateDrawState(TextPaint tp) {
//            tp.setFakeBoldText(true);//一种伪粗体效果，比原字体加粗的效果弱一点
             tp.setStyle(Paint.Style.FILL_AND_STROKE);
//             tp.setColor(Color.RED);//字体颜色
             tp.setStrokeWidth(1.5f);//控制字体加粗的程度
        }
    }
}

