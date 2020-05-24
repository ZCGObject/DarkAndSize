package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ikang.mydark.util.SharePreferenceUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_skip1, btn_skip2, btn_skip3;
    private TextView fsTv, duibiTv, fsTv1;


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

        btn_skip1.setOnClickListener(this);
        btn_skip2.setOnClickListener(this);
        btn_skip3.setOnClickListener(this);
        fsTv.setOnClickListener(this);
        fsTv1.setOnClickListener(this);
        duibiTv.setOnClickListener(this);

    }

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
