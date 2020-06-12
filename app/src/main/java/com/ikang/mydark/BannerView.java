package com.ikang.mydark;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/** banner无限循环滑动+自动播放
 * Created by zxg on 2016/11/9.
 * QQ:1092885570
 */

public class BannerView extends RelativeLayout {

    private static final String TAG = "BannerView--->>>";

    private int mPosition = 1;
    private Context mContext;
    public ViewPager vp_banner;
    private LinearLayout ll_indicator;

    //Banner展示的view
    private List<View> vp_views = new ArrayList<View>();
    private List<ImageView> dot_imgs = new ArrayList<ImageView>();
    //指示器图片资源
    private int[] indicatorImgRes = {R.drawable.point_guide_selected, R.drawable.point_guide_normal};

    private Timer mTimer;
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //实现循环自动播放的效果
            vp_banner.setCurrentItem(mPosition + 1);
        }
    };

    public BannerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        /**
         * 用Java代码创建布局
         */
        vp_banner = new ViewPager(mContext);
        LinearLayout.LayoutParams vp_param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        vp_banner.setLayoutParams(vp_param);

        ll_indicator = new LinearLayout(mContext);
        RelativeLayout.LayoutParams dot_param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        dot_param.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        dot_param.setMargins(0, 0, 0, 10);
        ll_indicator.setLayoutParams(dot_param);
        ll_indicator.setGravity(Gravity.CENTER_HORIZONTAL);

        this.addView(vp_banner);
        this.addView(ll_indicator);
    }

    /**
     * 设置banner展示的view，指示器图片为默认图片
     *
     * @param views banner展示的view
     */
    public void setView(List<View> views) {
        setView(views, null);
    }

    /**
     * 设置banner展示的view和指示器图片
     *
     * @param views        banner展示的view
     * @param indicatorRes 指示器图片
     */
    public void setView(List<View> views, int[] indicatorRes) {
        if (views != null) {
            vp_views = views;
        }

        vp_banner.setAdapter(new ViewPagerAdapter(vp_views));
        vp_banner.setOffscreenPageLimit(1);
        vp_banner.setCurrentItem(1);
        vp_banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG , "Scrolled  position = " + position + "---positionOffset = " + positionOffset + "---positionOffsetPixels = " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG , "111  position = " + position);
                //指示器跳转
                mPosition = position;
                int pageIndex = mPosition;
                if (mPosition == 0) {
                    pageIndex = dot_imgs.size();
                } else if (mPosition == dot_imgs.size() + 1) {
                    pageIndex = 1;
                }
                setIndicator(pageIndex);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e(TAG , "state = " + state);
                //ViewPager跳转
                int pageIndex = mPosition;
                if (mPosition == 0) {
                    pageIndex = dot_imgs.size();
                } else if (mPosition == dot_imgs.size() + 1) {
                    pageIndex = 1;
                }
                if (pageIndex != mPosition) {
                    //无滑动动画，直接跳转
                    vp_banner.setCurrentItem(pageIndex, false);
                    return;
                }

            }
        });

        //加载指示器
        if (indicatorRes != null && indicatorRes.length >= 2) {
            indicatorImgRes = indicatorRes;
        }
        for (int i = 0; i < vp_views.size() - 2; i++) {
            ImageView imageView = new ImageView(mContext);
            if (i == 0) {
                imageView.setBackgroundResource(indicatorImgRes[0]);
            } else {
                imageView.setBackgroundResource(indicatorImgRes[1]);
            }
            dot_imgs.add(imageView);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    30,
                    30);
            int margin_h = 30;
            int margin_v = 30;
            lp.setMargins(margin_h, margin_v, margin_h, margin_v);
            ll_indicator.addView(imageView, lp);
        }
    }

    /**
     * 设置指示器的图片
     *
     * @param position 当前banner位置
     */
    private void setIndicator(int position) {
        for (int i = 0; i < dot_imgs.size(); i++) {
            if (position == i + 1) {
                dot_imgs.get(i).setBackgroundResource(indicatorImgRes[0]);
            } else {
                dot_imgs.get(i).setBackgroundResource(indicatorImgRes[1]);
            }
        }
    }

    /**
     * 开启自动轮播
     *
     * @param period banner轮播的周期
     */
    public void startAutoPlay(long period) {
        //banner的vp_views数量大于1时，才允许自动轮播
        if (vp_views.size() > 1) {
            mTimer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    mHandle.sendEmptyMessage(1);
                }
            };
            mTimer.schedule(timerTask, 2000, period);
        }
    }

    /**
     * 关闭自动轮播
     */
    public void stopAutoPlay() {
        if (mTimer != null) {
            mTimer.cancel();
        }
    }
}