package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class VPActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();

    private Context mContext;

    private BannerView banner_view;
    private Button btn_autoplay;
    private Button btn_stopplay;

    private List<View> bannerViews = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_p);
        mContext = this;

        initView();
        initData();
    }

    private void initView(){
        banner_view = (BannerView)findViewById(R.id.banner_view);
        btn_autoplay = (Button) findViewById(R.id.btn_autoplay);
        btn_autoplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banner_view.startAutoPlay(1000);
            }
        });
        btn_stopplay = (Button) findViewById(R.id.btn_stopplay);
        btn_stopplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banner_view.stopAutoPlay();
            }
        });
    }

    private void initData(){
        int[] img_src = {R.drawable.guide_one, R.drawable.guide_two, R.drawable.guide_three};
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0; i < img_src.length+2; i++) {
            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(lp);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (i == 0){
                imageView.setImageBitmap(readBitmap(mContext, img_src[img_src.length-1]));
            } else if (i == img_src.length+1) {
                imageView.setImageBitmap(readBitmap(mContext, img_src[0]));
            } else {
                imageView.setImageBitmap(readBitmap(mContext, img_src[i - 1]));
            }
            bannerViews.add(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "bannerview onclick listener");
                }
            });
        }
        banner_view.setView(bannerViews/*, new int[]{R.drawable.ic_indicator_off, R.drawable.ic_indicator_on}*/);
    }

    /**
     * 以最小内存读取本地资源图片
     * @param context
     * @param bitmapResId
     * @return
     */
    public static Bitmap readBitmap(Context context, int bitmapResId){
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(bitmapResId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
}