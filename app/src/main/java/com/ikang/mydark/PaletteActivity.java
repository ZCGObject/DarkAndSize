package com.ikang.mydark;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv1, iv2, iv3;
    private View v1, v2, v3, v4, v5, v6;
    private View v11, v22, v33, v44, v55, v66;
    private View v111, v222, v333, v444, v555, v666;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);


        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);


        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        v4 = findViewById(R.id.v4);
        v5 = findViewById(R.id.v5);
        v6 = findViewById(R.id.v6);

        v11 = findViewById(R.id.v11);
        v22 = findViewById(R.id.v22);
        v33 = findViewById(R.id.v33);
        v44 = findViewById(R.id.v44);
        v55 = findViewById(R.id.v55);
        v66 = findViewById(R.id.v66);


        v111 = findViewById(R.id.v111);
        v222 = findViewById(R.id.v222);
        v333 = findViewById(R.id.v333);
        v444 = findViewById(R.id.v444);
        v555 = findViewById(R.id.v555);
        v666 = findViewById(R.id.v666);


        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv1:
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yu_0);
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(@Nullable Palette palette) {

                        int defaultColor = Color.parseColor("#b64242");

                        int mVibrantColor = palette.getVibrantColor(defaultColor);
                        int mDarkVibrantColor = palette.getDarkVibrantColor(defaultColor);
                        int mLightVibrantColor = palette.getLightVibrantColor(defaultColor);
                        int mMutedColor = palette.getMutedColor(defaultColor);
                        int mDarkMutedColor = palette.getDarkMutedColor(defaultColor);
                        int mLightMutedColor = palette.getLightMutedColor(defaultColor);

                        //获取到充满活力的色调
//                        Log.e("充满活力的色调---->>>",  palette.getVibrantSwatch().getRgb()+"");
                        v1.setBackgroundColor(mVibrantColor);
                        //获取充满活力的黑
//                        Log.e("获取充满活力的黑---->>>",  palette.getDarkVibrantSwatch().getRgb()+"");
                        v2.setBackgroundColor(mDarkVibrantColor);
                        //获取充满活力的亮
//                        Log.e("获取充满活力的亮---->>>",  palette.getLightVibrantSwatch().getRgb()+"");
                        v3.setBackgroundColor(mLightVibrantColor);
                        //获取柔和的色调
//                        Log.e("获取柔和的色调---->>>",  palette.getMutedSwatch().getRgb()+"");
                        v4.setBackgroundColor(mMutedColor);
                        //获取柔和的黑
//                        Log.e("获取柔和的黑---->>>",  palette.getDarkMutedSwatch().getRgb()+"");
                        v5.setBackgroundColor(mDarkMutedColor);
                        //获取柔和的亮
//                        Log.e("获取柔和的亮---->>>",  palette.getLightMutedSwatch().getRgb()+"");
                        v6.setBackgroundColor(mLightMutedColor);


                    }
                });
               




                break;
            case R.id.iv2:
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.hai_4);
                Palette.from(bitmap1).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(@Nullable Palette palette) {

                        int defaultColor = Color.parseColor("#b64242");

                        int mVibrantColor = palette.getVibrantColor(defaultColor);
                        int mDarkVibrantColor = palette.getDarkVibrantColor(defaultColor);
                        int mLightVibrantColor = palette.getLightVibrantColor(defaultColor);
                        int mMutedColor = palette.getMutedColor(defaultColor);
                        int mDarkMutedColor = palette.getDarkMutedColor(defaultColor);
                        int mLightMutedColor = palette.getLightMutedColor(defaultColor);

                        //获取到充满活力的色调
//                        Log.e("充满活力的色调---->>>",  palette.getVibrantSwatch().getRgb()+"");
                        v11.setBackgroundColor(mVibrantColor);
                        //获取充满活力的黑
//                        Log.e("获取充满活力的黑---->>>",  palette.getDarkVibrantSwatch().getRgb()+"");
                        v22.setBackgroundColor(mDarkVibrantColor);
                        //获取充满活力的亮
//                        Log.e("获取充满活力的亮---->>>",  palette.getLightVibrantSwatch().getRgb()+"");
                        v33.setBackgroundColor(mLightVibrantColor);
                        //获取柔和的色调
//                        Log.e("获取柔和的色调---->>>",  palette.getMutedSwatch().getRgb()+"");
                        v44.setBackgroundColor(mMutedColor);
                        //获取柔和的黑
//                        Log.e("获取柔和的黑---->>>",  palette.getDarkMutedSwatch().getRgb()+"");
                        v55.setBackgroundColor(mDarkMutedColor);
                        //获取柔和的亮
//                        Log.e("获取柔和的亮---->>>",  palette.getLightMutedSwatch().getRgb()+"");
                        v66.setBackgroundColor(mLightMutedColor);


                    }
                });
                break;
            case R.id.iv3:
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.jing_3);
                Palette.from(bitmap2).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(@Nullable Palette palette) {

                        int defaultColor = Color.parseColor("#b64242");

//                        int mVibrantColor = palette.getVibrantColor(defaultColor);
//                        int mDarkVibrantColor = palette.getDarkVibrantColor(defaultColor);
                        int mLightVibrantColor = palette.getLightVibrantColor(defaultColor);
//                        int mMutedColor = palette.getMutedColor(defaultColor);
//                        int mDarkMutedColor = palette.getDarkMutedColor(defaultColor);
//                        int mLightMutedColor = palette.getLightMutedColor(defaultColor);

                        //获取到充满活力的色调
//                        Log.e("充满活力的色调---->>>",  palette.getVibrantSwatch().getRgb()+"");
//                        v111.setBackgroundColor(mVibrantColor);
                        //获取充满活力的黑
//                        Log.e("获取充满活力的黑---->>>",  palette.getDarkVibrantSwatch().getRgb()+"");
//                        v222.setBackgroundColor(mDarkVibrantColor);
                        //获取充满活力的亮
//                        Log.e("获取充满活力的亮---->>>",  palette.getLightVibrantSwatch().getRgb()+"");
                        v333.setBackgroundColor(mLightVibrantColor);
                        //获取柔和的色调
//                        Log.e("获取柔和的色调---->>>",  palette.getMutedSwatch().getRgb()+"");
//                        v444.setBackgroundColor(mMutedColor);
                        //获取柔和的黑
//                        Log.e("获取柔和的黑---->>>",  palette.getDarkMutedSwatch().getRgb()+"");
//                        v555.setBackgroundColor(mDarkMutedColor);
                        //获取柔和的亮
//                        Log.e("获取柔和的亮---->>>",  palette.getLightMutedSwatch().getRgb()+"");
//                        v666.setBackgroundColor(mLightMutedColor);


                    }
                });
                break;
        }
    }
}