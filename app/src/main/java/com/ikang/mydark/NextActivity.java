package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ikang.mydark.util.SharePreferenceUtils;

public class NextActivity extends AppCompatActivity {

    private TextView duibiTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        setContentView(R.layout.activity_next);

        findViewById(R.id.duibiTv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartApp();
            }
        });
    }


    private void restartApp() {
        Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//与正常页面跳转一样可传递序列化数据,在Launch页面内获得
        intent.putExtra("REBOOT", "reboot");
        startActivity(intent);
    }

    private void restartApp1() {
        Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        //与正常页面跳转一样可传递序列化数据,在Launch页面内获得
        intent.putExtra("REBOOT","reboot");
        PendingIntent restartIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager mgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, restartIntent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
