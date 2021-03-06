package com.ikang.mydark;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ikang.mydark.aidltest.AidlTestActivity;
import com.ikang.mydark.fanshe.FanSheActivity;
import com.ikang.mydark.service.ServiceActivity;
import com.ikang.mydark.statictest.StaticTest0Activity;
import com.ikang.mydark.util.SharePreferenceUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_skip1, btn_skip2, btn_skip3;
    private TextView fsTv, duibiTv, fsTv1, cancelTv, VpTv, RvTv, tvPalette,
            tvText, tvDate, tvTest, tvDimen, tvReturn, tvBold, tvClone,
            tvFanshe, tvOOM, tvService, tvAidl;






    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(null != getIntent()){
            Log.e("000  onCreate------", getIntent().getStringExtra("REBOOT") + "--结束");
        }


        int state = (int) SharePreferenceUtils.get(this, "s", 1);
        if (state == 1) {
            setTheme(R.style.Default_TextSize_Small);
            setTheme(R.style.Text_Zh);
        } else if (state == 2) {
            setTheme(R.style.Default_TextSize_Middle);
            setTheme(R.style.Text_En);
        } else {
            setTheme(R.style.Default_TextSize_Big);
            setTheme(R.style.Text_Jp);
        }
        setContentView(R.layout.activity_main);



        btn_skip1 = findViewById(R.id.btn_skip1);
        btn_skip2 = findViewById(R.id.btn_skip2);
        btn_skip3 = findViewById(R.id.btn_skip3);
        fsTv = findViewById(R.id.fsTv);
        fsTv1 = findViewById(R.id.fsTv1);
        duibiTv = findViewById(R.id.duibiTv);
        cancelTv = findViewById(R.id.cancelTv);
        VpTv = findViewById(R.id.VpTv);
        RvTv = findViewById(R.id.RvTv);
        tvPalette = findViewById(R.id.tvPalette);
        tvText = findViewById(R.id.tvText);
        tvDate = findViewById(R.id.tvDate);
        tvTest = findViewById(R.id.tvTest);
        tvDimen = findViewById(R.id.tvDimen);
        tvReturn = findViewById(R.id.tvReturn);
        tvBold = findViewById(R.id.tvBold);
        tvClone = findViewById(R.id.tvClone);
        tvFanshe = findViewById(R.id.tvFanshe);
        tvOOM = findViewById(R.id.tvOOM);
        tvService = findViewById(R.id.tvService);
        tvAidl = findViewById(R.id.tvAidl);

        btn_skip1.setOnClickListener(this);
        btn_skip2.setOnClickListener(this);
        btn_skip3.setOnClickListener(this);
        fsTv.setOnClickListener(this);
        fsTv1.setOnClickListener(this);
        duibiTv.setOnClickListener(this);
        cancelTv.setOnClickListener(this);
        VpTv.setOnClickListener(this);
        RvTv.setOnClickListener(this);
        tvPalette.setOnClickListener(this);
        tvText.setOnClickListener(this);
        tvDate.setOnClickListener(this);
        tvTest.setOnClickListener(this);
        tvDimen.setOnClickListener(this);
        tvReturn.setOnClickListener(this);
        tvBold.setOnClickListener(this);
        tvClone.setOnClickListener(this);
        tvFanshe.setOnClickListener(this);
        tvOOM.setOnClickListener(this);
        tvService.setOnClickListener(this);
        tvAidl.setOnClickListener(this);

        TypedArray array = obtainStyledAttributes(R.style.Text_En, R.styleable.textD);
        String str = array.getString(R.styleable.textD_text_dong_tai);
        cancelTv.setText(str);
        array.recycle();

//        parseStyle(R.style.Text_Zh);
    }


    /**
     * 描述：动态解析 style
     */
//    private void parseStyle(@StyleRes int styleId) {
//        TypedArray array = obtainStyledAttributes(styleId, R.styleable.text);
//        CharSequence cancelText = array.getText(R.styleable.text_text_dong_tai);
//        cancelTv.setText(cancelText.toString());
//
//        array.recycle();
//    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(null != getIntent()){
            Log.e("111   onCreate------", getIntent().getStringExtra("REBOOT") + "--结束");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(null != getIntent().getStringExtra("REBOOT") && "reboot".equals(getIntent().getStringExtra("REBOOT"))){
                Log.e("222   onCreate------", getIntent().getStringExtra("REBOOT") + "--结束");
                startActivity(new Intent(this, NextActivity.class));
            }
        }
    }

    private static final String TAG = "BaseApplication--->>>";

    private float fs = 1.0f;

    @Override
    public Resources getResources() {
//        SharePreferenceUtils.put(this,"fs",0.6f);
        Log.e(TAG, "222  fs=" + fs);
        fs = (float) SharePreferenceUtils.get(this,"fs",1.0f);
        Log.e(TAG, "333  fs=" + fs);
        Resources res = super.getResources();
        Configuration config = res.getConfiguration();
        Log.e(TAG, "444  fs=" + config.fontScale);
        if (fs > 0.5) {//防止第一次获取SP时得到默认值0
            config.fontScale = fs;//设置正常字体大小的倍数
        }
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_skip1:

                SharePreferenceUtils.put(this, "s", 1);
                SharePreferenceUtils.put(this, "fs", 0.875);
                break;
            case R.id.btn_skip2:
                SharePreferenceUtils.put(this, "s", 2);
                SharePreferenceUtils.put(this, "fs", 1.25);
                break;
            case R.id.btn_skip3:
                SharePreferenceUtils.put(this, "s", 3);
                SharePreferenceUtils.put(this, "fs", 1.75);
                break;
            case R.id.fsTv:
                restartApp();
                break;

            case R.id.duibiTv:
                startActivity(new Intent(this, NextActivity.class));
                break;

            case R.id.fsTv1:
                fs+=0.2f;
                SharePreferenceUtils.put(this,"fs",fs);
                Log.e(TAG, "888  fs=" + fs);
                getResources();
                recreate();


                break;
            case R.id.VpTv:
                startActivity(new Intent(MainActivity.this, VPActivity.class));
                break;

            case R.id.RvTv:
                startActivity(new Intent(MainActivity.this, RecyclerviewSnapActivity.class));
                break;

            case R.id.tvPalette:
                startActivity(new Intent(MainActivity.this, PaletteActivity.class));
                break;

            case R.id.tvText:
                startActivity(new Intent(MainActivity.this, TextActivity.class));
                break;

            case R.id.tvDate:
                startActivity(new Intent(MainActivity.this, DateActivity.class));
                break;

            case R.id.tvTest:
//                byte[] content = new byte[1000 * 1000 * 40];
//                Log.e("length---->>>" , content.length+"");
//                startActivity(new Intent(this, StaticTestActivity.class));
//                startActivity(new Intent(this, CrashTestActivity.class));
//                startActivity(new Intent(this, HandlerTestActivity.class));
//                startActivity(new Intent(this, BianLiangTestActivity.class));
//                startActivity(new Intent(this, ThreadPoolTest1Activity.class));
                startActivity(new Intent(this, StaticTest0Activity.class));
                break;

            case R.id. tvDimen:
                startActivity(new Intent(MainActivity.this, DimenActivity.class));
                break;


            case R.id. tvReturn:
                startActivity(new Intent(MainActivity.this, TestReturnActivity.class));
                break;

            case R.id. tvBold:
                startActivity(new Intent(MainActivity.this, TextBoldActivity.class));
                break;

            case R.id.tvClone:
                startActivity(new Intent(MainActivity.this, CloneObjectTestActivity.class));
                break;

            case R.id.tvFanshe:
                startActivity(new Intent(MainActivity.this, FanSheActivity.class));
                break;

            case R.id.tvOOM:
                startActivity(new Intent(MainActivity.this, OomTestActivity.class));
                break;

            case R.id.tvService:
                startActivity(new Intent(MainActivity.this, ServiceActivity.class));
                break;

            case R.id.tvAidl:
                startActivity(new Intent(MainActivity.this, AidlTestActivity.class));
                break;

        }
    }


    private void restartApp() {
        Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//与正常页面跳转一样可传递序列化数据,在Launch页面内获得
        intent.putExtra("REBOOT", "reboot");
        startActivity(intent);
    }
}
