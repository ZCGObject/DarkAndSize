package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;

public class UrlSchemeActivity extends AppCompatActivity {

    public static final String TAG = "UrlScheme--->>>";
    String scheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_scheme);


        Intent intent = getIntent();
        scheme = intent.getScheme();
        Log.i(TAG, "scheme:::" + scheme);
        String dataString = intent.getDataString();
        Log.i(TAG, "dataString:::" + dataString);
        Uri uri = intent.getData();
        if (uri != null) {
            //完整的url信息
            String url = uri.toString();
            Log.i(TAG, "url:::" + url);
            //scheme部分
            String schemes = uri.getScheme();
            Log.i(TAG, "schemes:::" + schemes);
            //host部分
            String host = uri.getHost();
            Log.i(TAG, "host:::" + host);
            //port部分
            int port = uri.getPort();
            Log.i(TAG, "port:::" + port);
            //访问路径
            String path = uri.getPath();
            Log.i(TAG, "path:::" + path);
            //编码路径
            String path1 = uri.getEncodedPath();
            Log.i(TAG, "path1:::" + path1);
            //query部分
            String queryString = uri.getQuery();
            Log.i(TAG, "queryString:::" + queryString);
            //获取参数值
            String systemInfo = uri.getQueryParameter("id");
            Log.i(TAG, "systemInfo:::" + systemInfo);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(TextUtils.isEmpty(scheme)){
                finish();
            }else {
               startActivity(new Intent(this, MainActivity.class));
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}